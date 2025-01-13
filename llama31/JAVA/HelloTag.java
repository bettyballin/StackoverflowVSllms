import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

public class HelloTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("Hello, World!");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}