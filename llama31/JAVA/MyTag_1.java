import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

// MyTag.java
public class MyTag_1_1 extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        // Generate your custom control here
        String customControl = "<div>This is a custom control</div>";
        pageContext.getOut().print(customControl);
        return SKIP_BODY;
    }

    public static void main(String[] args) {
        // This main method is not typically used in a JSP tag class,
        // but it's included here as per the original code.
    }
}