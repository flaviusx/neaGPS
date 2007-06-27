/*
 * Copyright 2006, XpertNet SARL, and individual contributors as indicated
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
 * @author jeremi
 *
 * This class is originally from http://gwt.bouwkamp.com/
 * licenced under the Apache Software licence:
 * See http://www.opensource.org/licenses/apachepl.php
 *
 *
 */
package org.curriki.gwt.client.widgets.roundedpanel;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>A Panel to create rounded corners similar to other known Google(tm)
 * applications. Basically the html of the rounded corners looks as follows
 * (with some extra styling to make it really work):</p>
 * <pre>
 * &lt;div&gt
 *      &lt;div style="margin:0 2px"&gt;&lt;/div&gt;
 *      &lt;div style="margin:0 1px"&gt;&lt;/div&gt;
 *      &lt;div&gt;your widget&lt;/div&gt;
 *      &lt;div style="margin:0 1px"&gt;&lt/div&gt;
 *      &lt;div style="margin:0 2px"&gt;&lt/div&gt;
 * &lt;/div&gt;
 * </pre>
 * <p>
 * Use the class as follows:</p>
 * <p>Create panel with all corners rounded:</p>
 * <pre>
 *     // all 4 corners are rounded.
 *     RoundedPanel rp = new RoundedPanel();
 * </pre>
 * <p>or with custom set corners, like only on the left</p>
 * <pre>
 *     // custom set corners
 *     RoundedPanel rp = new RoundedPanel(corners);
 * </pre>
 *
 * <p>By default the classname assigned to the rounded corners is "rp".
 * You need this to set the color of the rounded corners to match the rest
 * of you widget. e.g. <code>.rp { background-color:#c3d9ff; }</code>
 * If you want another class name, use the method <code>setLineStyleName</code>.
 * </p>
 *
 * @author Hilbrand Bouwkamp(hs@bouwkamp.com)
 * @version 1.2
 */
public class RoundedPanel extends ComplexPanel {
	/**
	 * <code>TOPLEFT</code> top left rounded corner
	 */
	public final static int TOPLEFT     = 1;
	/**
	 * <code>TOPRIGHT</code> top right rounded corner
	 */
	public final static int TOPRIGHT    = 2;
	/**
	 * <code>BOTTOMLEFT</code> bottom left rounded corner
	 */
	public final static int BOTTOMLEFT  = 4;
	/**
	 * <code>BOTTOMRIGHT</code> bottom right rounded corner
	 */
	public final static int BOTTOMRIGHT = 8;
	/**
	 * <code>BOTTOM</code> rounded corners at the top
	 */
	public final static int TOP = TOPLEFT | TOPRIGHT;
	/**
	 * <code>TOP</code> rounded corners at the bottom
	 */
	public final static int BOTTOM = BOTTOMLEFT | BOTTOMRIGHT;
	/**
	 * <code>LEFT</code> rounded corners on the left side
	 */
	public final static int LEFT = TOPLEFT | BOTTOMLEFT;
	/**
	 * <code>RIGHT</code> rounded corners on the right side
	 */
	public final static int RIGHT = TOPRIGHT | BOTTOMRIGHT;
	/**
	 * <code>ALL</code> rounded corners on all sides
	 */
	public final static int ALL = TOP | BOTTOM;

	// private Element variables
	private Element body;  // body of widget
	private Element div2t; // margin 2 top line
	private Element div1t; // margin 1 top line
	private Element divElement; // div element containing widget
	private Element div1b; // margin 1 bottom line
	private Element div2b; // margin 2 bottom line
	private final static String RPSTYLE = "rp";

	/**
	 * <p>Creates a new <code>RoundedPanel</code> with custom rounded corners on
	 * the given widget <code>w</code>. Every combination of corners can be set
	 * via the <code>corners</code> argument. Use the static constants to set
	 * the corners. For example if you want to create a panel with only rounded
	 * corners at the left, use:<br>
	 * <code>new RoundedPanel(yourWidget, RoundedPanel.LEFT);</code></p>
	 *
	 * @param corners set custom rounded corners.
	 * @param w widget to add corners to.
	 */
	public RoundedPanel(Widget w, int corners) {
		super();
		body = DOM.createDiv();
		if (is(corners,TOP)) {
			div2t = createLine(corners & TOP, '2');
			DOM.appendChild(body, div2t);
			div1t = createLine(corners & TOP, '1');
			DOM.appendChild(body, div1t);
		}
		divElement = DOM.createDiv();
		DOM.appendChild(body, divElement);
		if (is(corners,BOTTOM)) {
			div1b = createLine(corners & BOTTOM, '1');
			DOM.appendChild(body, div1b);
			div2b = createLine(corners & BOTTOM, '2');
			DOM.appendChild(body, div2b);
		}
		setCornerStyleName(RPSTYLE);
		setElement(body);
		if (null != w) add(w);
	}

	/**
	 * <p>Creates a new <code>RoundedPanel</code> with all corners rounded on
	 * the given widget <code>w</code>.</p>
	 *
	 * @param w widget to add corners to.
	 */
	public RoundedPanel(Widget w) {
		this(w, ALL);
	}

	/**
	 * <p>Creates a new <code>RoundedPanel</code> with custom rounding but with
	 * no widget set. Use <code>add</code> to set widget.
	 *
	 * @param corners set custom rounded corners.
	 */
	public RoundedPanel(int corners) {
		this(null, corners);
	}

	/**
	 * <p>Creates a new <code>RoundedPanel</code> with all corners rounded but
	 * with no widget set. Use <code>add</code> to set widget.
	 */
	public RoundedPanel() {
		this(null, ALL);
	}

	/**
	 * <p>Creates div element representing part of the rounded corner.</p>
	 *
	 * @param corner corner mask to set rounded corner.
	 * @param width margin width for line.
	 */
	private Element createLine(int corner, char width) {
		// margin 2 fields : top/bottom right/left  => "0 <width>px"
		// margin 4 fields : top right bottom left  => "0 <width>px 0 <width>px"
		String margin = (corner == TOP || corner == BOTTOM) ? "0 " + width + "px"
			: (is(corner, LEFT) ? "0 0 0 " + width + "px"
							: "0 " + width + "px 0 0");
		Element div = DOM.createDiv();
		DOM.setStyleAttribute(div, "fontSize", "0px");
		DOM.setStyleAttribute(div, "height", "1px");
		DOM.setStyleAttribute(div, "lineHeight", "1px");
		DOM.setStyleAttribute(div, "margin", margin);
		DOM.setInnerHTML(div, "&nbsp;");
		return div;
	}

	// convience method for mask test
	private boolean is(int input, int mask) {
		return (input & mask) > 0;
	}

	/**
	 * <p>Set the style of the RoundedPanel. In most cases this is not necessary
	 * and setting the style on the widget to which the <code>RoundedPanel</code>
	 * is applied should be set, as is done when not using the RoundedPanel</code>
	 * </p>
	 *
	 * @param style css style name
	 */
	public void setStyleName(String style) {
		DOM.setAttribute(body, "className", style);
	}

	/**
	 * <p>Set the css style name of the rounded corners div's. Default the css stylename
	 * is <code>rp</code>. Use it to set the colors of the corner. For example:
	 * <code>.rp { background-color:#c3d9ff; }</code>.</p>
	 * <p>A custom style might be needed when the corners are visible only when a panel
	 * is selected. Use this method to set the custom style name and add something
	 * like the following to the stylesheet:<br>
	 * .selected .rp { background-color:#c3d9ff; }
	 * </p>
	 *
	 * @param style css style name.
	 */
	public void setCornerStyleName(String style) {
		if(null != div2t) DOM.setAttribute(div2t, "className", style);
		if(null != div1t) DOM.setAttribute(div1t, "className", style);
		if(null != div1b) DOM.setAttribute(div1b, "className", style);
		if(null != div2b) DOM.setAttribute(div2b, "className", style);
	}

	/**
	 * <p>Sets the Widget to which the rounded corners will be added. Use
	 * this method when the child widget was not passed via the constructor.
	 * USe the <code>add</code> method for late binding, e.g. when using this
	 * class as a container to which one widget at the time is added and
	 * replaced with another widget.</p>
	 *
	 * @param w widget to apply the rounded corners to.
	 */
	public void add(Widget w) {
		super.add(w, divElement);
	}
}
