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

import com.xpn.xwiki.XWiki;
import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiDocument;

import java.util.List;
import java.util.ArrayList;

public class RollbackAction extends XWikiAction {
	public boolean action(XWikiContext context) throws XWikiException {
        XWiki xwiki = context.getWiki();
        XWikiResponse response = context.getResponse();
        XWikiDocument doc = context.getDoc();
        RollbackForm form = (RollbackForm) context.getForm();

        String confirm = form.getConfirm();
        String rev = form.getRev();
        String language = form.getLanguage();
        XWikiDocument tdoc;

        if((confirm == null) || (!confirm.equals("1"))){
            return true;
        }

        if ((language==null)||(language.equals(""))||(language.equals("default"))||(language.equals(doc.getDefaultLanguage()))) {
            // Need to save parent and defaultLanguage if they have changed
            tdoc = doc;
        } else {
            tdoc = doc.getTranslatedDocument(language, context);
            if (tdoc == doc) {
                tdoc = new XWikiDocument(doc.getSpace(), doc.getName());
                tdoc.setLanguage(language);
            }
            tdoc.setTranslation(1);
        }

        XWikiDocument newdoc = xwiki.rollback(tdoc, rev, context);
        // forward to view
        String redirect = Utils.getRedirect("view", context);
        sendRedirect(response, redirect);
        return false;
	}

    public String render(XWikiContext context) throws XWikiException {
        handleRevision(context);
      	return "rollback";
    }
}
