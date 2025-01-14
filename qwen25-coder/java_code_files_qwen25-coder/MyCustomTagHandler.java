package com.mycompany;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspApplicationContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.el.ValueExpression;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class MyCustomTagHandler extends SimpleTagSupport {
    private Object items;
    private String test;

    public void setItems(Object items) { this.items = items; }
    public void setTest(String test) { this.test = test; }

    @Override
    public void doTag() throws JspException, IOException {
        Collection<?> collection = (Collection<?>) items;
        if (collection == null) return;

        JspContext jspContext = getJspContext();
        ELContext context = jspContext.getELContext();

        ServletContext servletContext = ((PageContext) jspContext).getServletContext();
        JspApplicationContext jspAppContext = JspFactory.getDefaultFactory().getJspApplicationContext(servletContext);
        ExpressionFactory factory = jspAppContext.getExpressionFactory();

        for (Object item : collection) {
            context.getELResolver().setValue(context, null, "item", item);
            ValueExpression expr = factory.createValueExpression(context, "#{" + test + "}", Object.class);

            if ((Boolean) expr.getValue(context)) { // Assuming the test returns a boolean
                getJspBody().invoke(null);
            }
        }
    }

    public static void main(String[] args) {
    }
}