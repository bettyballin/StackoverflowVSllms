import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;

public class ContentCreator {
    public static void main(String[] args) {
        // This code snippet seems to be a part of a JSP (Java Server Pages) file.
        // To make it compile with javac, we need to simulate the JSP environment.
        // Here, we're assuming the 'request' object is of type PageContext.

        PageContext pageContext = null; // Initialize with a proper PageContext in a real JSP environment
        try {
            pageContext.setAttribute("content", new Content("Insert Title Here", "Insert Body Here"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

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