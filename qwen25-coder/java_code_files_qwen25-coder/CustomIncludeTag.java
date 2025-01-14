// CustomIncludeTag.java
import java.lang.String;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class CustomIncludeTag extends IncludeTagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            return super.doStartTag();
        } catch (JspException e) {
            pageContext.setAttribute("exception", e);
            pageContext.include("/error.jsp");
            return SKIP_BODY;
        }
    }
}

public static void main(String[] args) {
}