import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomControlTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            // Generate your custom tag's output here, for example:
            pageContext.getOut().print("My custom control.");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}