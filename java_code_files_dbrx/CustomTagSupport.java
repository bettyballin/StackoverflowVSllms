import java.lang.String;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class CustomTagSupport extends BodyTagSupport {
    private PageContext pageCntxt;

    public int doStartTag() throws JspException {
        // Save pageContext object to use it in the body of your include file.
        this.pageCntxt = this.pageContext;
        return BodyTagSupport.EVAL_BODY_INCLUDE;
    }
    public static void main(String[] args) {
    }
}