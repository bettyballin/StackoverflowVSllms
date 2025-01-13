import java.lang.String;
// DisabledTag.java
package com.example.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DisabledTag extends TagSupport {

    private boolean disabled;

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public int doStartTag() throws JspException {
        if (disabled) {
            pageContext.getOut().print(" disabled=\"disabled\"");
        }
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}