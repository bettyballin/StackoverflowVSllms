import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;

public class ContentGenerator_1_1 {
    public static void main(String[] args) {
        // This code snippet seems to be a JSP (Java Server Pages) scriptlet
        // It cannot be run as a standalone Java application
        // However, we can simulate the environment for demonstration purposes

        // Assuming we have a PageContext object
        PageContext pageContext = null; // in a real scenario, this would be provided by the JSP engine

        try {
            // Assuming we have a JspWriter object
            JspWriter out = pageContext.getOut();
            // Create a Content object
            Content content = new Content("Insert Title Here", "Insert Body Here");
            // Set the content attribute in the request
            pageContext.getRequest().setAttribute("content", content);
        } catch (JspException e) {
            System.out.println("JSP Exception: " + e.getMessage());
        }
    }
}

// Assuming we have a Content class
class Content {
    private String title;
    private String body;

    public Content(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}