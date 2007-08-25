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

package com.xpn.xwiki.objects.classes;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.objects.BaseCollection;
import com.xpn.xwiki.objects.BaseProperty;
import com.xpn.xwiki.objects.IntegerProperty;
import com.xpn.xwiki.objects.meta.PropertyMetaClass;
import com.xpn.xwiki.plugin.query.XWikiCriteria;
import com.xpn.xwiki.plugin.query.XWikiQuery;
import com.xpn.xwiki.web.XWikiMessageTool;

import org.apache.ecs.xhtml.div;
import org.apache.ecs.xhtml.input;
import org.apache.ecs.xhtml.label;
import org.apache.ecs.xhtml.option;
import org.apache.ecs.xhtml.select;

import java.util.Map;

public class BooleanClass extends PropertyClass
{

    public BooleanClass(PropertyMetaClass wclass)
    {
        super("boolean", "Boolean", wclass);
    }

    public BooleanClass()
    {
        this(null);
        setDisplayFormType("select");
    }

    public void setDisplayType(String type)
    {
        setStringValue("displayType", type);
    }

    public String getDisplayType()
    {
        String dtype = getStringValue("displayType");
        if ((dtype == null) || (dtype.equals(""))) {
            return "yesno";
        }
        return dtype;
    }

    public String getDisplayFormType()
    {
        String dtype = getStringValue("displayFormType");
        if ((dtype == null) || (dtype.equals(""))) {
            return "radio";
        }
        return dtype;
    }

    public void setDisplayFormType(String type)
    {
        setStringValue("displayFormType", type);
    }

    public void setDefaultValue(int dvalue)
    {
        setIntValue("defaultValue", dvalue);
    }

    public int getDefaultValue()
    {
        return getIntValue("defaultValue", -1);
    }

    public BaseProperty fromString(String value)
    {
        BaseProperty property = newProperty();
        Number nvalue = null;
        if ((value != null) && (!value.equals("")))
            nvalue = new Integer(value);
        property.setValue(nvalue);
        return property;
    }

    public BaseProperty newProperty()
    {
        BaseProperty property = new IntegerProperty();
        property.setName(getName());
        return property;
    }

    public void displayView(StringBuffer buffer, String name, String prefix,
        BaseCollection object, XWikiContext context)
    {
        IntegerProperty prop = (IntegerProperty) object.safeget(name);
        if (prop == null)
            return;

        Integer iValue = (Integer) prop.getValue();
        if (iValue != null) {
            int value = iValue.intValue();
            buffer.append(getDisplayValue(context, value));
        }
    }

    public void displayEdit(StringBuffer buffer, String name, String prefix,
        BaseCollection object, XWikiContext context)
    {
        String displayFormType = getDisplayFormType();

        if (getDisplayType().equals("checkbox")) {
            displayFormType = "checkbox";
        }

        if (displayFormType.equals("checkbox")) {
            displayCheckboxEdit(buffer, name, prefix, object, context);
        } else if (displayFormType.equals("select")) {
            displaySelectEdit(buffer, name, prefix, object, context);
        } else {
            displayRadioEdit(buffer, name, prefix, object, context);
        }
    }

    public void displaySelectEdit(StringBuffer buffer, String name, String prefix,
        BaseCollection object, XWikiContext context)
    {
        select select = new select(prefix + name, 1);
        String String0 = getDisplayValue(context, 0);
        String String1 = getDisplayValue(context, 1);
        int nb1 = 1;
        int nb2 = 2;

        option[] options;

        if (getDefaultValue() == -1) {
            options =
                new option[] {new option("---", ""), new option(String1, "1"),
                new option(String0, "0")};
            options[0].addElement("---");
            options[1].addElement(String1);
            options[2].addElement(String0);
        } else {
            options = new option[] {new option(String1, "1"), new option(String0, "0")};
            options[0].addElement(String1);
            options[1].addElement(String0);
            nb1 = 0;
            nb2 = 1;
        }

        try {
            IntegerProperty prop = (IntegerProperty) object.safeget(name);
            Integer ivalue = (prop == null) ? null : (Integer) prop.getValue();
            if (ivalue != null) {
                int value = ivalue.intValue();
                if (value == 1)
                    options[nb1].setSelected(true);
                else if (value == 0)
                    options[nb2].setSelected(true);
            } else {
                int value = getDefaultValue();
                if (value == 1)
                    options[nb1].setSelected(true);
                else if (value == 0)
                    options[nb2].setSelected(true);
                else if (value == -1) {
                    options[0].setSelected(true);
                }
            }
        } catch (Exception e) {
            // This should not happen
            e.printStackTrace();
        }
        select.addElement(options);
        buffer.append(select.toString());
    }

    public void displayRadioEdit(StringBuffer buffer, String name, String prefix,
        BaseCollection object, XWikiContext context)
    {
        String StringNone = getDisplayValue(context, 2);
        String StringTrue = getDisplayValue(context, 1);
        String StringFalse = getDisplayValue(context, 0);
        div[] inputs;

        input radioNone = new input(input.radio, prefix + name, "");
        input radioTrue = new input(input.radio, prefix + name, "1");
        input radioFalse = new input(input.radio, prefix + name, "0");
        label labelNone = new label();
        label labelTrue = new label();
        label labelFalse = new label();
        div divNone = new div();
        div divTrue = new div();
        div divFalse = new div();
        labelNone.addElement(radioNone);
        labelNone.addElement(StringNone);
        divNone.addElement(labelNone);
        labelTrue.addElement(radioTrue);
        labelTrue.addElement(StringTrue);
        divTrue.addElement(labelTrue);
        labelFalse.addElement(radioFalse);
        labelFalse.addElement(StringFalse);
        divFalse.addElement(labelFalse);

        radioTrue.setID(prefix + name);

        if (getDefaultValue() == -1) {
            inputs = new div[] {divNone, divTrue, divFalse};
        } else {
            inputs = new div[] {divTrue, divFalse};
        }

        try {
            IntegerProperty prop = (IntegerProperty) object.safeget(name);
            Integer ivalue = (prop == null) ? null : (Integer) prop.getValue();
            if (ivalue != null) {
                int value = ivalue.intValue();
                if (value == 1)
                    radioTrue.setChecked(true);
                else if (value == 0)
                    radioFalse.setChecked(true);
            } else {
                int value = getDefaultValue();
                if (value == 1)
                    radioTrue.setChecked(true);
                else if (value == 0)
                    radioFalse.setChecked(true);
                else if (value == -1)
                    radioNone.setChecked(true);
            }
        } catch (Exception e) {
            // This should not happen
            e.printStackTrace();
        }

        for (int i = 0; i < inputs.length; i++) {
            buffer.append(inputs[i].toString());
        }
    }

    public void displayCheckboxEdit(StringBuffer buffer, String name, String prefix,
        BaseCollection object, XWikiContext context)
    {
        org.apache.ecs.xhtml.input check = new input(input.checkbox, prefix + name, 1);
        org.apache.ecs.xhtml.input checkNo = new input(input.hidden, prefix + name, 0);

        try {
            IntegerProperty prop = (IntegerProperty) object.safeget(name);
            if (prop != null) {
                Integer ivalue = (Integer) prop.getValue();
                if (ivalue != null) {
                    int value = ivalue.intValue();
                    if (value == 1)
                        check.setChecked(true);
                    else if (value == 0)
                        check.setChecked(false);
                } else {
                    int value = getDefaultValue();
                    if (value == 1)
                        check.setChecked(true);
                    else
                        check.setChecked(false);
                }
            }
        } catch (Exception e) {
            // This should not happen
            e.printStackTrace();
        }
        buffer.append(check.toString());
        buffer.append(checkNo.toString());
    }

    private String getDisplayValue(XWikiContext context, int value)
    {
        try {
            XWikiMessageTool msg = context.getMessageTool();
            String strname = getDisplayType() + "_" + value;
            String result = msg.get(strname);
            if (result.equals(strname)) {
                if (value == 2) {
                    return "---";
                }
                return "" + value;
            }
            return result;
        } catch (Exception e) {
            return "" + value;
        }
    }

    public String displaySearch(String name, String prefix, XWikiCriteria criteria,
        XWikiContext context)
    {
        if (getDisplayType().equals("input")) {
            return super.displaySearch(name, prefix, criteria, context);
        } else if (getDisplayType().equals("radio")) {
            return displayCheckboxSearch(name, prefix, criteria, context);
        } else {
            return displaySelectSearch(name, prefix, criteria, context);
        }
    }

    public String displaySelectSearch(String name, String prefix, XWikiCriteria criteria,
        XWikiContext context)
    {
        select select = new select(prefix + name, 1);
        select.setMultiple(true);
        select.setSize(3);
        String String0 = getDisplayValue(context, 0);
        String String1 = getDisplayValue(context, 1);

        option[] options =
            {new option("---", ""), new option(String1, "1"), new option(String0, "0")};
        options[0].addElement("---");
        options[1].addElement(String1);
        options[2].addElement(String0);

        /*
         * try { IntegerProperty prop = (IntegerProperty) object.safeget(name); if (prop!=null) {
         * Integer ivalue = (Integer)prop.getValue(); if (ivalue!=null) { int value =
         * ivalue.intValue(); if (value==1) options[1].setSelected(true); else if (value==0)
         * options[2].setSelected(true); } else { int value = getDefaultValue(); if (value==1)
         * options[1].setSelected(true); else if (value==0) options[2].setSelected(true); } } }
         * catch (Exception e) { // This should not happen e.printStackTrace(); }
         */
        select.addElement(options);
        return select.toString();
    }

    public String displayCheckboxSearch(String name, String prefix, XWikiCriteria criteria,
        XWikiContext context)
    {
        StringBuffer buffer = new StringBuffer();
        org.apache.ecs.xhtml.input check = new input(input.checkbox, prefix + name, 1);
        org.apache.ecs.xhtml.input checkNo = new input(input.hidden, prefix + name, 0);

        /*
         * try { IntegerProperty prop = (IntegerProperty) object.safeget(name); if (prop!=null) {
         * Integer ivalue = (Integer)prop.getValue(); if (ivalue!=null) { int value =
         * ivalue.intValue(); if (value==1) check.setChecked(true); else if (value==0)
         * check.setChecked(false); } else { int value = getDefaultValue(); if (value==1)
         * check.setChecked(true); else check.setChecked(false); } }} catch (Exception e) { // This
         * should not happen e.printStackTrace(); }
         */
        buffer.append(check.toString());
        buffer.append(checkNo.toString());
        return buffer.toString();
    }

    public void fromSearchMap(XWikiQuery query, Map map)
    {
        String[] data = (String[]) map.get("");
        if (data != null) {
            Object[] data2 = new Object[data.length];
            for (int i = 0; i < data.length; i++)
                data2[i] = fromString(data[i]).getValue();
            query.setParam(getObject().getName() + "_" + getName(), data2);
        }
    }
}
