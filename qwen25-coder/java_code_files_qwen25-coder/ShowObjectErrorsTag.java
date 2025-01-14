package com.example;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ShowObjectErrorsTag extends SimpleTagSupport {
    private String objectName;

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        // Assume request is stored in page context or session
        RequestObject request = (RequestObject) getJspContext().getAttribute("request");
        
        if (request.errorSystem.hasErrors(objectName)) {
            out.println("<table>");
            for (String error : request.errorSystem.getErrors(objectName)) {
                out.println(String.format("<tr><td class=\"acError\">%s</td></tr>", error));
            }
            out.println("</table>");
        }
    }

    public static void main(String[] args) {
    }
}

class RequestObject {
    public ErrorSystem errorSystem = new ErrorSystem();

    class ErrorSystem {
        public boolean hasErrors(String objectName) {
            // stub method
            return false;
        }

        public List<String> getErrors(String objectName) {
            // stub method
            return new ArrayList<String>();
        }
    }
}