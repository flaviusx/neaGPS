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

package com.xpn.xwiki.user.api;

import com.xpn.xwiki.XWiki;
import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;

import java.util.Collection;
import java.util.List;

public interface XWikiGroupService {
    public void init(XWiki xwiki, XWikiContext context) throws XWikiException;
    public void initCache(XWikiContext context) throws XWikiException;
    public void initCache(int iCapacity, XWikiContext context) throws XWikiException;
    public void flushCache();
    public Collection listGroupsForUser(String username, XWikiContext context) throws XWikiException;
    public void addUserToGroup(String user, String database, String group, XWikiContext context) throws XWikiException;
    public List listMemberForGroup(String s, XWikiContext context) throws XWikiException;
    public List listAllGroups(XWikiContext context) throws XWikiException;

}
