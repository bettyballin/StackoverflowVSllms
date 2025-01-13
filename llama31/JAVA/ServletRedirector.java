import javax.servlet.http.HttpServletResponse;

public class ServletRedirector {
    public void redirect(HttpServletResponse response) {
        response.sendRedirect("/anotherServlet");
    }

    public static void main(String[] args) {
        // This main method doesn't do anything with the ServletRedirector class.
        // In a real-world scenario, you would use a servlet container like Tomcat to run a servlet.
    }
}