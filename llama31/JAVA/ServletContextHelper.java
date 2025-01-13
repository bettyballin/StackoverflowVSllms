import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public class ServletContextHelper {
    private ServletContext servletContext;
    private JspWriter out;

    public ServletContextHelper(ServletContext servletContext, JspWriter out) {
        this.servletContext = servletContext;
        this.out = out;
    }

    public void printInitParameter() {
        out.print("<br>" + servletContext.getInitParameter("GlobalName"));
    }

    public static void main(String[] args) {
        // This main method is not used in a servlet context, but added to make the code compile
    }
}