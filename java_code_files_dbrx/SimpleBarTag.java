import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class SimpleBarTag extends SimpleTagSupport {
    private String className;
    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("<div class=\"" + className + "\">");
            // your static text or bodyContent goes here.
        getJspContext().getOut().write("</div>");
     }

    public static void main(String[] args) {
    }
}