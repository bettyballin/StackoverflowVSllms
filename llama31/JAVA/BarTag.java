import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.TagSupport;

public class BarTag extends TagSupport implements BodyTag {
    @Override
    public int doStartTag() throws JspException {
        // Write the static output directly to the response
        pageContext.getOut().write("<div class=\"bar\">");
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        pageContext.getOut().write("</div>");
        return EVAL_PAGE;
    }

    @Override
    public void doInitBody() throws JspException {
        // No-op, since we're not using the body content
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        // No-op, since we're not using the body content
    }

    public static void main(String[] args) {
    }
}