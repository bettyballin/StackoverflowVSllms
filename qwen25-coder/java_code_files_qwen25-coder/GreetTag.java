import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetTag extends SimpleTagSupport {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello, " + userName);
    }

    public static void main(String[] args) {
        // Main method (optional)
    }
}