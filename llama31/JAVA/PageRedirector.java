import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class PageRedirector {
    // Redirect the user to a new page
    public void redirect(HttpServletResponse response) {
        response.sendRedirect("nextPage.jsp");
    }

    public static void main(String[] args) {
        // This main method does nothing, as the HttpServletResponse object is needed to call sendRedirect
        System.out.println("This class is meant to be used in a servlet context.");
    }
}