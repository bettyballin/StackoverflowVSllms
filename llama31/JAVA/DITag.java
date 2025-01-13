package com.example.test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DITag extends TagSupport {
  private String id;

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public int doStartTag() throws JspException {
    Object bean = null; // instantiate your service bean here
    pageContext.setAttribute(id, bean);
    return SKIP_BODY;
  }

  public static void main(String[] args) {
  }
}