/*
 * Copyright 2006-2007, XpertNet SARL, and individual contributors as indicated
 * by the contributors.txt.
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

package com.xpn.xwiki.web;

import com.novell.ldap.util.Base64;
import com.xpn.xwiki.XWiki;
import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.plugin.fileupload.FileUploadPlugin;
import com.xpn.xwiki.xmlrpc.XWikiXMLRPCRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.ecs.Filter;
import org.apache.ecs.filter.CharacterFilter;
import org.apache.log4j.MDC;
import org.apache.struts.upload.MultipartRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class Utils {

    public static void parseTemplate(String template, XWikiContext context) throws XWikiException {
        parseTemplate(template, true, context);
    }

    public static void parseTemplate(String template, boolean write, XWikiContext context) throws XWikiException {
        XWikiResponse response = context.getResponse();

        // Set content-type and encoding (this can be changed in the future by pages themselves)
        if (context.getResponse() instanceof XWikiPortletResponse) {
            response.setContentType("text/html");
        } else {
            response.setContentType("text/html; charset=" + context.getWiki().getEncoding());
        }

        String action = context.getAction();
        if ((!"download".equals(action))
                && (!"skin".equals(action))) {
            if (context.getResponse() instanceof XWikiServletResponse) {
                // Add a last modified to tell when the page was last updated
                if (context.getWiki().getXWikiPreferenceAsLong("headers_lastmodified", 0, context) != 0) {
                    if (context.getDoc() != null)
                        response.setDateHeader("Last-Modified", context.getDoc().getDate().getTime());
                }
                // Set a nocache to make sure the page is reloaded after an edit
                if (context.getWiki().getXWikiPreferenceAsLong("headers_nocache", 1, context) != 0) {
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Cache-Control", "no-cache");
                }
                // Set an expires in one month
                long expires = context.getWiki().getXWikiPreferenceAsLong("headers_expires", -1, context);
                if (expires == -1) {
                    response.setDateHeader("Expires", -1);
                } else if (expires != 0) {
                    response.setDateHeader("Expires", (new Date()).getTime() + 30 * 24 * 3600 * 1000L);
                }
            }
        }

        if (("download".equals(action))
                || ("skin".equals(action))) {
            // Set a nocache to make sure these files are not cached by proxies
            if (context.getWiki().getXWikiPreferenceAsLong("headers_nocache", 1, context) != 0) {
                response.setHeader("Cache-Control", "no-cache");
            }
        }


        String content = context.getWiki().parseTemplate(template + ".vm", context);
        content = content.trim();

        if (content.equals("")) {
            // get Error template "This template does not exist
            content = context.getWiki().parseTemplate("templatedoesnotexist.vm", context);
            content = content.trim();
        }

        if (!context.isFinished()) {
            if (context.getResponse() instanceof XWikiServletResponse) {
                // Set the content length to the numnber of bytes, not the
                // string length, so as to handle multi-byte encodings

                try {
                    response.setContentLength(content.getBytes(context.getWiki().getEncoding()).length);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (write)
                    response.getWriter().write(content);
            } catch (IOException e) {
                throw new XWikiException(XWikiException.MODULE_XWIKI_APP,
                        XWikiException.ERROR_XWIKI_APP_SEND_RESPONSE_EXCEPTION,
                        "Exception while sending response", e);
            }
        }

        try {
            response.getWriter().flush();
        } catch (Throwable e) {
        }
    }

    public static String getRedirect(XWikiRequest request, String defaultRedirect) {
        String redirect;
        redirect = request.getParameter("xredirect");
        if ((redirect == null) || (redirect.equals("")))
            redirect = defaultRedirect;
        return redirect;
    }

    public static String getRedirect(String action, String params, XWikiContext context) {
        String redirect;
        redirect = context.getRequest().getParameter("xredirect");
        if ((redirect == null) || (redirect.equals("")))
            redirect = context.getDoc().getURL(action, params, true, context);
        return redirect;
    }

    public static String getRedirect(String action, XWikiContext context) {
        return getRedirect(action, null, context);
    }

    public static String getPage(XWikiRequest request, String defaultpage) {
        String page;
        page = request.getParameter("xpage");
        if ((page == null) || (page.equals("")))
            page = defaultpage;
        return page;
    }

    public static String getFileName(List filelist, String name) {
        FileItem fileitem = null;
        for (int i = 0; i < filelist.size(); i++) {
            FileItem item = (FileItem) filelist.get(i);
            if (name.equals(item.getFieldName())) {
                fileitem = item;
                break;
            }
        }

        if (fileitem == null)
            return null;

        return fileitem.getName();
    }

    public static byte[] getContent(List filelist, String name) throws XWikiException {
        FileItem fileitem = null;
        for (int i = 0; i < filelist.size(); i++) {
            FileItem item = (FileItem) filelist.get(i);
            if (name.equals(item.getFieldName())) {
                fileitem = item;
                break;
            }
        }

        if (fileitem == null)
            return null;

        byte[] data = new byte[(int) fileitem.getSize()];
        InputStream fileis = null;
        try {
            fileis = fileitem.getInputStream();
            fileis.read(data);
            fileis.close();
        } catch (IOException e) {
            throw new XWikiException(XWikiException.MODULE_XWIKI_APP,
                    XWikiException.ERROR_XWIKI_APP_UPLOAD_FILE_EXCEPTION,
                    "Exception while reading uploaded parsed file", e);
        }
        return data;
    }

    public static XWikiContext prepareContext(String action, XWikiRequest request, XWikiResponse response,
                                              XWikiEngineContext engine_context) throws XWikiException {
        // Test works with xwiki-test.cfg instead of xwiki.cfg
        XWikiContext context = new XWikiContext();
        String dbname = "xwiki";
        URL url = XWiki.getRequestURL(request);
        context.setURL(url);
        // Push the URL into the Log4j NDC context
        MDC.put("url", url);

        context.setEngineContext(engine_context);
        context.setRequest(request);
        context.setResponse(response);
        context.setAction(action);
        context.setDatabase(dbname);

        int mode = 0;
        if (request instanceof XWikiXMLRPCRequest) {
            mode = XWikiContext.MODE_XMLRPC;
        } else if (request instanceof XWikiServletRequest) {
            mode = XWikiContext.MODE_SERVLET;
        } else if (request instanceof XWikiPortletRequest) {
            mode = XWikiContext.MODE_PORTLET;
        }
        context.setMode(mode);
        return context;
    }

    /**
     * Append request parameters from the specified String to the specified
     * Map.  It is presumed that the specified Map is not accessed from any
     * other thread, so no synchronization is performed.
     * <p/>
     * <strong>IMPLEMENTATION NOTE</strong>:  URL decoding is performed
     * individually on the parsed name and value elements, rather than on
     * the entire query string ahead of time, to properly deal with the case
     * where the name or value includes an encoded "=" or "&" character
     * that would otherwise be interpreted as a delimiter.
     *
     * @param data Input string containing request parameters
     * @throws IllegalArgumentException if the data is malformed
     *                                  <p/>
     *                                  Code borrowed from Apache Tomcat 5.0
     */
    public static Map parseParameters(String data, String encoding)
            throws UnsupportedEncodingException {

        if ((data != null) && (data.length() > 0)) {

            // use the specified encoding to extract bytes out of the
            // given string so that the encoding is not lost. If an
            // encoding is not specified, let it use platform default
            byte[] bytes = null;
            try {
                if (encoding == null) {
                    bytes = data.getBytes();
                } else {
                    bytes = data.getBytes(encoding);
                }
            } catch (UnsupportedEncodingException uee) {
            }

            return parseParameters(bytes, encoding);
        }

        return new HashMap();
    }

    /**
     * Append request parameters from the specified String to the specified
     * Map.  It is presumed that the specified Map is not accessed from any
     * other thread, so no synchronization is performed.
     * <p/>
     * <strong>IMPLEMENTATION NOTE</strong>:  URL decoding is performed
     * individually on the parsed name and value elements, rather than on
     * the entire query string ahead of time, to properly deal with the case
     * where the name or value includes an encoded "=" or "&" character
     * that would otherwise be interpreted as a delimiter.
     * <p/>
     * NOTE: byte array data is modified by this method.  Caller beware.
     *
     * @param data     Input string containing request parameters
     * @param encoding Encoding to use for converting hex
     * @throws UnsupportedEncodingException if the data is malformed
     *                                      <p/>
     *                                      Code borrowed from Apache Tomcat 5.0
     */
    public static Map parseParameters(byte[] data, String encoding)
            throws UnsupportedEncodingException {

        Map map = new HashMap();

        if (data != null && data.length > 0) {
            int ix = 0;
            int ox = 0;
            String key = null;
            String value = null;
            while (ix < data.length) {
                byte c = data[ix++];
                switch ((char) c) {
                    case '&':
                        value = new String(data, 0, ox, encoding);
                        if (key != null) {
                            putMapEntry(map, key, value);
                            key = null;
                        }
                        ox = 0;
                        break;
                    case '=':
                        if (key == null) {
                            key = new String(data, 0, ox, encoding);
                            ox = 0;
                        } else {
                            data[ox++] = c;
                        }
                        break;
                    case '+':
                        data[ox++] = (byte) ' ';
                        break;
                    case '%':
                        data[ox++] = (byte) ((convertHexDigit(data[ix++]) << 4)
                                + convertHexDigit(data[ix++]));
                        break;
                    default:
                        data[ox++] = c;
                }
            }
            //The last value does not end in '&'.  So save it now.
            if (key != null) {
                value = new String(data, 0, ox, encoding);
                putMapEntry(map, key, value);
            }
        }
        return map;
    }

    /**
     * Convert a byte character value to hexidecimal digit value.
     *
     * @param b the character value byte
     *          <p/>
     *          Code borrowed from Apache Tomcat 5.0
     */
    private static byte convertHexDigit(byte b) {
        if ((b >= '0') && (b <= '9')) return (byte) (b - '0');
        if ((b >= 'a') && (b <= 'f')) return (byte) (b - 'a' + 10);
        if ((b >= 'A') && (b <= 'F')) return (byte) (b - 'A' + 10);
        return 0;
    }

    /**
     * Put name value pair in map.
     * <p/>
     * Put name and value pair in map.  When name already exist, add value
     * to array of values.
     * <p/>
     * Code borrowed from Apache Tomcat 5.0
     */
    private static void putMapEntry(Map map, String name, String value) {
        String[] newValues = null;
        String[] oldValues = (String[]) map.get(name);
        if (oldValues == null) {
            newValues = new String[1];
            newValues[0] = value;
        } else {
            newValues = new String[oldValues.length + 1];
            System.arraycopy(oldValues, 0, newValues, 0, oldValues.length);
            newValues[oldValues.length] = value;
        }
        map.put(name, newValues);
    }

    public static String formEncode(String value) {
        Filter filter = new CharacterFilter();
        filter.removeAttribute("'");
        String svalue = filter.process(value);
        return svalue;
    }

    public static String SQLFilter(String text) {
        try {
            return text.replaceAll("'", "''");
        } catch (Exception e) {
            return text;
        }
    }

    // TODO: Duplicate of XWiki.getURLEncoded(). Keep only one
    public static String encode(String name, XWikiContext context) {
        try {
            return URLEncoder.encode(name, context.getWiki().getEncoding());
        } catch (Exception e) {
            return name;
        }
    }

    public static String decode(String name, XWikiContext context) {
        try {
            // Make sure + is considered as a space
            String result = name.replaceAll("\\+", " ");

            // It seems Internet Explorer can send us back UTF-8
            // instead of ISO-8859-1 for URLs
            if (Base64.isValidUTF8(result.getBytes(), false))
                result = new String(result.getBytes(), "UTF-8");

            // Still need to decode URLs
            return URLDecoder.decode(result, context.getWiki().getEncoding());
        } catch (Exception e) {
            return name;
        }
    }

    public static FileUploadPlugin handleMultipart(HttpServletRequest request, XWikiContext context) {
        FileUploadPlugin fileupload = null;
        try {
            if (request instanceof MultipartRequestWrapper) {
                fileupload = new FileUploadPlugin("fileupload", "fileupload", context);
                fileupload.loadFileList(context);
                context.put("fileuploadplugin", fileupload);
                MultipartRequestWrapper mpreq = (MultipartRequestWrapper) request;
                List fileItems = fileupload.getFileItems(context);
                for (Iterator iter = fileItems.iterator(); iter.hasNext();) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        String sName = item.getFieldName();
                        String sValue = item.getString();
                        mpreq.setParameter(sName, sValue);
                    }
                }
            }
        }
        catch (Exception e) {
            if( (e instanceof XWikiException) &&
                    (((XWikiException)e).getCode() == XWikiException.ERROR_XWIKI_APP_FILE_EXCEPTION_MAXSIZE ))
            {
                context.put("exception",e);
            }else {
                 e.printStackTrace();
            }

        }
        return fileupload;
    }

}
