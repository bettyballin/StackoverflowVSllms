import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// MyTag.java
public class MyTag_3_3 extends TagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        out.print("Hello, " + name);
        return SKIP_BODY;
    }

    public static void main(String[] args) {
        // This main method does nothing but is necessary for the class to be executable.
        // In a real-world scenario, this class would be part of a web application and 
        // would not be run directly from the command line.
    }
}