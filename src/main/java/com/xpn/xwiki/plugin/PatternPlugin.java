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

package com.xpn.xwiki.plugin;

import com.xpn.xwiki.XWiki;
import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.doc.XWikiDocument;
import com.xpn.xwiki.notify.DocObjectChangedRule;
import com.xpn.xwiki.notify.XWikiDocChangeNotificationInterface;
import com.xpn.xwiki.notify.XWikiNotificationRule;
import com.xpn.xwiki.objects.BaseObject;
import com.xpn.xwiki.objects.StringProperty;
import com.xpn.xwiki.render.WikiSubstitution;
import com.xpn.xwiki.util.Util;
import org.apache.ecs.filter.CharacterFilter;
import org.apache.tools.ant.util.StringUtils;

import java.util.Vector;

public class PatternPlugin extends XWikiDefaultPlugin implements XWikiDocChangeNotificationInterface {
    Vector patterns = new Vector();
    Vector results = new Vector();
    Vector descriptions = new Vector();
    WikiSubstitution patternListSubstitution;

    public PatternPlugin(String name, String className, XWikiContext context) {
        super(name, className, context);
        init(context);

        // register for any modifications of the Plugins.PatternPlugin document..
        XWiki xwiki = context.getWiki();
        xwiki.getNotificationManager().addNamedRule("Plugins.PatternPlugin",
                              new DocObjectChangedRule(this, "Plugins.PatternPlugin"));

    }

    public void init(XWikiContext context) {
        XWiki xwiki = context.getWiki();
        try {
            patterns = new Vector();
            results = new Vector();
            descriptions = new Vector();
            XWikiDocument pattern_doc = xwiki.getDocument("Plugins", "PatternPlugin", context);
            Vector patternlist = pattern_doc.getObjects("Plugins.PatternPlugin");
            if (patternlist!=null) {
            for (int i=0;i<patternlist.size();i++) {
                    BaseObject obj = (BaseObject) patternlist.get(i);
                    if (obj==null)
                        continue;
                    patterns.add(((StringProperty)obj.get("pattern")).getValue().toString());
                    results.add(((StringProperty)obj.get("result")).getValue().toString());
                    descriptions.add(((StringProperty)obj.get("description")).getValue().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        patternListSubstitution = new WikiSubstitution(context.getUtil(),"%PATTERNS%");
        // Add a notification rule if the preference property plugin is modified
    }


    public void addPattern(String pattern, String result, String description) {
        patterns.add(pattern);
        results.add(result);
        descriptions.add(description);
    }

    public String getPatternList() {
        CharacterFilter filter = new CharacterFilter();
        StringBuffer list = new StringBuffer();
        list.append("{pre}\n");
        list.append("<table border=1>");
        list.append("<tr><td><strong>Pattern</strong></td>");
        list.append("<td><strong>Result</strong></td><td><strong>Description</strong></td></tr>");
        for (int i=0;i<patterns.size();i++) {
            list.append("<tr><td>");
            list.append(filter.process((String)patterns.get(i)));
            list.append("</td><td>");
            list.append(filter.process((String)results.get(i)));
            list.append("</td><td>");
            list.append(descriptions.get(i));
            list.append("</td></tr>");
        }
        list.append("</table>");
        list.append("\n{/pre}");
        return list.toString();
    }

    public String commonTagsHandler(String line, XWikiContext context) {
        String subst = getPatternList();
        subst = StringUtils.replace(subst,"$","\\$");
        patternListSubstitution.setSubstitution(subst);
        line = patternListSubstitution.substitute(line);
        return line;
    }

    public String startRenderingHandler(String line, XWikiContext context) {
        return line;
    }

    public String outsidePREHandler(String line, XWikiContext context) {
        Util util = context.getUtil();

        for (int i=0;i<patterns.size();i++) {
         String pattern = (String) patterns.get(i);
         String result = (String) results.get(i);
         try {
           if (pattern.startsWith("s/"))
            line = util.substitute(pattern,line);
           else
            line = StringUtils.replace(line, " " + pattern, " " + result);
         } catch (Exception e) {
             // Log a error but do not fail..
         }
        }

        return line;
    }

    public String insidePREHandler(String line, XWikiContext context) {
        return line;
    }

    public String endRenderingHandler(String line, XWikiContext context) {
        return line;
    }

    public void notify(XWikiNotificationRule rule, XWikiDocument newdoc, XWikiDocument olddoc, int event, XWikiContext context) {
     // If the PatternPlugin document has been modified we need to reload the patterns
     init(context);
    }
}
