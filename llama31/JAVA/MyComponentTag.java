package com.example;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyComponentTag extends TagSupport {
  public int doStartTag() throws JspException {
    // Generate HTML for the component
    String html = "<div>My Component</div>";
    JspWriter out = pageContext.getOut();
    out.print(html);
    return EVAL_BODY_INCLUDE;
  }

  public static void main(String[] args) {
    System.out.println("This is a simple JSP tag but cannot be executed directly.");
    System.out.println("It requires a JSP context which is not present in a standalone Java application.");
  }
}