import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class JspWriterBodyTag extends BodyTagSupport {
    public int doEndTag() throws JspException {
        try {
            // Fetch JSP writer object from pageContext.
            final JspWriter out = this.pageContext.getOut();
            if (out != null) {
                // Print the body of your tag using saved JspWriter object.
                getBodyContent().writeOut(out);
            }
        } catch (IOException e) {
            throw new JspException("Error writing out contents.", e);
        }
        return super.doEndTag();
    }

    public static void main(String[] args) {
    }
}