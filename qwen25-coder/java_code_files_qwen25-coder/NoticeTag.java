import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class NoticeTag extends SimpleTagSupport {
    private ImportantNotice importantNotice;

    public void setImportantNotice(ImportantNotice importantNotice) {
        this.importantNotice = importantNotice;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (getJspBody() != null && importantNotice != null) {
            JspWriter out = getJspContext().getOut();
            out.println("<div class=\"importantNotice\">");
            // Evaluate the body to ensure nested tags are processed
            getJspBody().invoke(null);
            out.println("   <div class=\"importantnoticedates\">Posted: " + importantNotice.getDateFrom() + " End: " + importantNotice.getDateTo() + "</div>");
            out.println("   <div class=\"noticeAuthor\">- " + importantNotice.getAuthor() + "</div>");
            out.println("</div>");
        }
    }

    public static void main(String[] args) {
    }
}

// Placeholder for ImportantNotice class
class ImportantNotice {
    public String getDateFrom() {
        return "DateFrom";
    }

    public String getDateTo() {
        return "DateTo";
    }

    public String getAuthor() {
        return "Author";
    }
}