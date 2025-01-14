package com.example.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class DIServiceTag extends SimpleTagSupport {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // Instantiate your service
        MyService myService = new MyService();

        // Store the variable in the page context (or request, session, etc. as needed)
        getJspContext().setAttribute(id, myService, PageContext.PAGE_SCOPE);
    }

    public static void main(String[] args) {
    }
}