import java.lang.String;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class WidgetManagerTag extends BodyTagSupport {
    private String layoutTemplate = "auto / auto"; // Default to a simple 2x2 grid

    public void setLayoutTemplate(String layoutTemplate) {
        this.layoutTemplate = layoutTemplate;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<div style='display: grid; grid-template-columns: " + layoutTemplate + ";'>");
        } catch (IOException e) {
            throw new JspException("Error in widgetManagerTag", e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</div>");
        } catch (IOException e) {
            throw new JspException("Error in widgetManagerTag", e);
        }
        return EVAL_PAGE;
    }

    public static void main(String[] args) {
    }
}