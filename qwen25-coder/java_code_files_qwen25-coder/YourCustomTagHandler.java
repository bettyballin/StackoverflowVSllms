package com.example;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class YourCustomTagHandler extends SimpleTagSupport {
    private Map<String, Object> dynamicAttributes;

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if (dynamicAttributes == null) {
            dynamicAttributes = new HashMap<>();
        }
        dynamicAttributes.put(localName, value);
    }

    @Override
    public void doTag() throws JspException, IOException {
        // Access your dynamic attributes here
        getJspContext().getOut().write("Received attribute: " + dynamicAttributes.get("someUnexpectedAttribute"));
    }

    public static void main(String[] args) {
    }
}