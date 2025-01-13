import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.PageContext;

// MyTag.java
public class MyTag_2_2 extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("<div class='my-control'>");
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("</div>");
        return EVAL_PAGE;
    }

    public static void main(String[] args) {
        // This main method is empty and doesn't actually test the tag.
        // For a real test, you'd need to use this tag in a JSP page.
    }
}