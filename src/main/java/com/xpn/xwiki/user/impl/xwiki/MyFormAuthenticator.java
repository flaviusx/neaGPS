/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *
 */

package com.xpn.xwiki.user.impl.xwiki;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.authenticator.Authenticator;
import org.securityfilter.authenticator.FormAuthenticator;
import org.securityfilter.filter.SecurityRequestWrapper;
import org.securityfilter.filter.URLPatternMatcher;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.web.SavedRequestRestorerFilter;

public class MyFormAuthenticator extends FormAuthenticator implements Authenticator, XWikiAuthenticator
{
    private static final Log log = LogFactory.getLog(MyFormAuthenticator.class);

    /**
     * Show the login page.
     * 
     * @param request the current request
     * @param response the current response
     */
    public void showLogin(HttpServletRequest request, HttpServletResponse response, XWikiContext context)
        throws IOException
    {
        if ("1".equals(request.getParameter("basicauth"))) {
            String realmName = context.getWiki().Param("xwiki.authentication.realmname");
            if (realmName == null) {
                realmName = "XWiki";
            }
            MyBasicAuthenticator.showLogin(request, response, realmName);
        } else {
            showLogin(request, response);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.securityfilter.authenticator.Authenticator#showLogin(HttpServletRequest, HttpServletResponse)
     */
    @Override
    public void showLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String savedRequestId = request.getParameter(SavedRequestRestorerFilter.SAVED_REQUESTS_IDENTIFIER);
        if (StringUtils.isEmpty(savedRequestId)) {
            // Save this request
            savedRequestId = SavedRequestRestorerFilter.saveRequest(request);
        }

        // Redirect to login page
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + this.loginPage + "?"
            + SavedRequestRestorerFilter.SAVED_REQUESTS_IDENTIFIER + "=" + savedRequestId));
        return;
    }

    @Override
    public boolean processLogin(SecurityRequestWrapper request, HttpServletResponse response) throws Exception
    {
        return processLogin(request, response, null);
    }

    private String convertUsername(String username, XWikiContext context)
    {
        return context.getWiki().convertUsername(username, context);
    }

    /**
     * Process any login information that was included in the request, if any. Returns true if SecurityFilter should
     * abort further processing after the method completes (for example, if a redirect was sent as part of the login
     * processing).
     * 
     * @param request
     * @param response
     * @return true if the filter should return after this method ends, false otherwise
     */
    public boolean processLogin(SecurityRequestWrapper request, HttpServletResponse response, XWikiContext context)
        throws Exception
    {
        try {
            Principal principal = MyBasicAuthenticator.checkLogin(request, response, context);
            if (principal != null) {
                return false;
            }
            if ("1".equals(request.getParameter("basicauth"))) {
                return true;
            }
        } catch (Exception e) {
            // in case of exception we continue on Form Auth.
            // we don't want this to interfere with the most common behavior
        }

        // process any persistent login information, if user is not already logged in,
        // persistent logins are enabled, and the persistent login info is present in this request
        if (this.persistentLoginManager != null) {
            String username =
                convertUsername(this.persistentLoginManager.getRememberedUsername(request, response), context);
            String password = this.persistentLoginManager.getRememberedPassword(request, response);

            Principal principal = authenticate(username, password, context);

            if (principal != null) {
                if (log.isDebugEnabled()) {
                    log.debug("User " + principal.getName() + " has been authentified from cookie");
                }
                request.setUserPrincipal(principal);
            } else if (username != null || password != null) {
                // failed authentication with remembered login, better forget login now
                this.persistentLoginManager.forgetLogin(request, response);
            }
        }

        // process login form submittal
        if ((this.loginSubmitPattern != null) && request.getMatchableURL().endsWith(this.loginSubmitPattern)) {
            String username = convertUsername(request.getParameter(FORM_USERNAME), context);
            String password = request.getParameter(FORM_PASSWORD);
            String rememberme = request.getParameter(FORM_REMEMBERME);
            rememberme = (rememberme == null) ? "false" : rememberme;
            return processLogin(username, password, rememberme, request, response, context);
        }
        return false;
    }

    /**
     * Process any login information passed in parameter (username, password). Returns true if SecurityFilter should
     * abort further processing after the method completes (for example, if a redirect was sent as part of the login
     * processing).
     * 
     * @param request
     * @param response
     * @return true if the filter should return after this method ends, false otherwise
     */
    public boolean processLogin(String username, String password, String rememberme, SecurityRequestWrapper request,
        HttpServletResponse response, XWikiContext context) throws Exception
    {
        Principal principal = authenticate(username, password, context);
        if (principal != null) {
            // login successful
            if (log.isInfoEnabled()) {
                log.info("User " + principal.getName() + " has been logged-in");
            }

            // invalidate old session if the user was already authenticated, and they logged in as a different user
            if (request.getUserPrincipal() != null && !username.equals(request.getRemoteUser())) {
                request.getSession().invalidate();
            }

            // manage persistent login info, if persistent login management is enabled
            if (this.persistentLoginManager != null) {
                // did the user request that their login be persistent?
                if (rememberme != null) {
                    // remember login
                    this.persistentLoginManager.rememberLogin(request, response, username, password);
                } else {
                    // forget login
                    this.persistentLoginManager.forgetLogin(request, response);
                }
            }

            request.setUserPrincipal(principal);
            Boolean bAjax = (Boolean) context.get("ajax");
            if ((bAjax == null) || (!bAjax.booleanValue())) {
                String continueToURL = getContinueToURL(request);
                // This is the url that the user was initially accessing before being prompted for login.
                response.sendRedirect(response.encodeRedirectURL(continueToURL));
            }
        } else {
            // login failed
            // set response status and forward to error page
            if (log.isInfoEnabled()) {
                log.info("User " + username + " login has failed");
            }

            String returnCode = context.getWiki().Param("xwiki.authentication.unauthorized_code");
            int rCode = HttpServletResponse.SC_UNAUTHORIZED;
            if ((returnCode != null) && (!returnCode.equals(""))) {
                try {
                    rCode = Integer.parseInt(returnCode);
                } catch (Exception e) {
                    rCode = HttpServletResponse.SC_UNAUTHORIZED;
                }
            }
            response.setStatus(rCode); // TODO: Does this work? (200 in case of error)
        }
        return true;
    }

    /**
     * FormAuthenticator has a special case where the user should be sent to a default page if the user spontaneously
     * submits a login request.
     * 
     * @param request
     * @return a URL to send the user to after logging in
     */
    private String getContinueToURL(HttpServletRequest request)
    {
        String savedURL = request.getParameter("xredirect");
        if (StringUtils.isEmpty(savedURL)) {
            savedURL = SavedRequestRestorerFilter.getOriginalUrl(request);
        }

        if (!StringUtils.isEmpty(savedURL)) {
            return savedURL;
        }
        return request.getContextPath() + this.defaultPage;
    }

    public static Principal authenticate(String username, String password, XWikiContext context) throws XWikiException
    {
        return context.getWiki().getAuthService().authenticate(username, password, context);
    }

    /**
     * {@inheritDoc}
     * 
     * @see Authenticator#processLogout(SecurityRequestWrapper, HttpServletResponse, URLPatternMatcher)
     */
    @Override
    public boolean processLogout(SecurityRequestWrapper securityRequestWrapper,
        HttpServletResponse httpServletResponse, URLPatternMatcher urlPatternMatcher) throws Exception
    {
        boolean result = super.processLogout(securityRequestWrapper, httpServletResponse, urlPatternMatcher);
        if (result == true) {
            if (this.persistentLoginManager != null) {
                this.persistentLoginManager.forgetLogin(securityRequestWrapper, httpServletResponse);
            }
        }
        return result;
    }
}
