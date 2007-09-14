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


package com.xpn.xwiki.render;

import org.apache.commons.lang.StringUtils;
import org.apache.oro.text.regex.*;

import java.util.ArrayList;
import java.util.List;


public class PreTagSubstitution extends WikiSubstitution {
    private int counter = 0;
    private List list = new ArrayList();
    private boolean removePre = false;

    public PreTagSubstitution(com.xpn.xwiki.util.Util util, boolean removepre) {
        super(util);
        setPattern("{pre}.*?{/pre}", Perl5Compiler.CASE_INSENSITIVE_MASK | Perl5Compiler.SINGLELINE_MASK);
        setRemovePre(removepre);
    }

    public void appendSubstitution(StringBuffer stringBuffer, MatchResult matchResult, int i, PatternMatcherInput minput, PatternMatcher patternMatcher, Pattern pattern) {
        String content = matchResult.group(0);
        if (isRemovePre()) {
           content = getUtil().substitute("s/{pre}//ig", content);
           content = getUtil().substitute("s/{\\/pre}//ig", content);
        }
        getList().add(content);
        stringBuffer.append("%_" + counter + "_%");
        counter++;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String insertNonWikiText(String content) {
        for (int i=0;i<list.size();i++)
            content = StringUtils.replace(content, "%_" + i + "_%", (String) list.get(i));
         return content;
    }

    public boolean isRemovePre() {
        return removePre;
    }

    public void setRemovePre(boolean remove) {
        this.removePre = remove;
    }

}
