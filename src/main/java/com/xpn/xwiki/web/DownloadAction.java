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
 */
package com.xpn.xwiki.web;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiAttachment;
import com.xpn.xwiki.doc.XWikiDocument;
import com.xpn.xwiki.plugin.XWikiPluginManager;
import com.xpn.xwiki.util.Util;

import java.io.IOException;

public class DownloadAction extends XWikiAction
{
    /**
     * The identifier of the download action.
     */
    public static final String ACTION_NAME = "download";

    public String getFileName(String path, String action)
    {
        path = path.substring(path.indexOf("/" + action));
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            pos = path.indexOf("/", pos + 1);
        }
        if (path.indexOf("/", pos + 1) > 0) {
            return path.substring(pos + 1, path.indexOf("/", pos + 1));
        }
        return path.substring(pos + 1);
    }

    public String render(XWikiContext context) throws XWikiException
    {
        XWikiRequest request = context.getRequest();
        XWikiResponse response = context.getResponse();
        XWikiDocument doc = context.getDoc();
        String path = request.getRequestURI();
        String filename = Util.decodeURI(getFileName(path, "download"), context);
        XWikiAttachment attachment;

        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            attachment = (XWikiAttachment) doc.getAttachmentList().get(id);
        } else {
            attachment = doc.getAttachment(filename);
        }

        if (attachment == null) {
            Object[] args = {filename};
            throw new XWikiException(XWikiException.MODULE_XWIKI_APP,
                XWikiException.ERROR_XWIKI_APP_ATTACHMENT_NOT_FOUND, "Attachment {0} not found",
                null, args);
        }

        XWikiPluginManager plugins = context.getWiki().getPluginManager();
        attachment = plugins.downloadAttachment(attachment, context);
        // Choose the right content type
        String mimetype = attachment.getMimeType(context);
        response.setContentType(mimetype);
        boolean forceDownload = "1".equals(request.getParameter("force-download"));

        String ofilename =
            Util.encodeURI(attachment.getFilename(), context).replaceAll("\\+", " ");

        // The inline attribute of Content-Disposition tells the browser that they should display
        // the downloaded file in the page (see http://www.ietf.org/rfc/rfc1806.txt for more
        // details). We do this so that JPG, GIF, PNG, etc are displayed without prompting a Save
        // dialog box. However, all mime types that cannot be displayed by the browser do prompt a
        // Save dialog box (exe, zip, xar, etc).
        String dispType = "inline";
        if (forceDownload) {
            dispType = "attachment";
        }

        // see http://www.mnot.net/cache_docs/ for detailed explanations for
        // a better caching strategy
        String serverETag = ofilename + attachment.getVersion();

        long lastModifOnClient = request.getDateHeader("If-Modified-Since");
        long lastModifOnServer = attachment.getDate().getTime();
        if(!forceDownload && lastModifOnClient != -1 && lastModifOnClient >= lastModifOnServer) {
            boolean shouldntDeliver = true;
            String clientETag = request.getHeader("If-None-Match");
            if(clientETag!=null) {// also "validate" with the ETag, not only the if-modified
                shouldntDeliver = clientETag.equals(serverETag);
            }
            if(shouldntDeliver) {
                response.setStatus(XWikiResponse.SC_NOT_MODIFIED);
                return null;
            }
        }

        response.addHeader("Content-disposition", dispType + "; filename=\"" + ofilename + "\"");

        response.setDateHeader("Last-Modified", lastModifOnServer);
        // 7*24*60*60*1000l = 604800 (seconds in 7 days)
        response.setDateHeader("Expires", System.currentTimeMillis() + 604800000l);
        response.addHeader("Cache-Control","max-age: 604800");
        response.addHeader("ETag", serverETag);
        // Sending the content of the attachment
        byte[] data;
        try {
            data = attachment.getContent(context);
        } catch (XWikiException e) {
            Object[] args = {filename};
            throw new XWikiException(XWikiException.MODULE_XWIKI_APP,
                XWikiException.ERROR_XWIKI_APP_ATTACHMENT_NOT_FOUND,
                "Attachment content {0} not found", null, args);
        }

        response.setContentLength(data.length);
        try {
            response.getOutputStream().write(data);
        } catch (IOException e) {
            throw new XWikiException(XWikiException.MODULE_XWIKI_APP,
                XWikiException.ERROR_XWIKI_APP_SEND_RESPONSE_EXCEPTION,
                "Exception while sending response", e);
        }
        return null;
    }
}
