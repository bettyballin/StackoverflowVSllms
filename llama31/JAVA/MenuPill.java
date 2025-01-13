import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class MenuPill extends BodyTagSupport {
    public int doStartTag() throws JspException {
        try {
            pageContext.include("/menu/menu.jsp");
        } catch (javax.servlet.ServletException e) {
            throw new JspException(e);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
        BodyContent body = getBodyContent();
        String bodyContent = body.getString();
        // Now include the body content in the JSP file
        pageContext.setAttribute("menuBody", bodyContent);
        return SKIP_BODY;
    }

    public static void main(String[] args) {
    }
}