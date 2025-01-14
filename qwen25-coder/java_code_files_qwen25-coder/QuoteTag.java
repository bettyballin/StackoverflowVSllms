import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class QuoteTag extends SimpleTagSupport {
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (getJspBody() != null || author != null) {
            JspWriter out = getJspContext().getOut();
            out.println("<div class=\"quote\">");
            // Evaluate the body to capture text between tags
            getJspBody().invoke(null);
            if (author != null) {
                out.println(" <span class=\"authorofquote\">" + author + "</span>");
            }
            out.println("</div>");
        }
    }

    public static void main(String[] args) {
    }
}