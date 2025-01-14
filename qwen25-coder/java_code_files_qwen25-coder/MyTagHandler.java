import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// Define a custom tag handler
public class MyTagHandler extends SimpleTagSupport {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("Hello: " + message);
    }

    public static void main(String[] args) {
    }
}