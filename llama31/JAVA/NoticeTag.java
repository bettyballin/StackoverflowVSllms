import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;

public class NoticeTag extends TagSupport {
    private ImportantNotice importantNotice;

    public void setImportantNotice(ImportantNotice importantNotice) {
        this.importantNotice = importantNotice;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.println("<div class=\"importantNotice\">");
        out.println("   " + importantNotice.getMessage());
        // Create a BodyContent object to evaluate the inner tag
        BodyContent bodyContent = getBodyContent();
        if (bodyContent == null) {
            bodyContent = new BodyContent(out);
            setBodyContent(bodyContent);
        }
        // Evaluate the inner tag
        bodyContent.clearBody();
        bodyContent.append(importantNotice.getMessage());
        // Write the evaluated content to the output
        out.println(bodyContent.getString());
        out.println("   <div class=\"importantnoticedates\">Posted: " + importantNotice.getDateFrom() + " End: " + importantNotice.getDateTo() + "</div>");
        out.println("   <div class=\"noticeAuthor\">- " + importantNotice.getAuthor() + "</div>");
        out.println("</div>");
        return EVAL_BODY_INCLUDE;
    }
}