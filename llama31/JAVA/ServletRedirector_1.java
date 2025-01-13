import javax.servlet.http.HttpServletResponse;

public class ServletRedirector_1_1 {
    private HttpServletResponse response;

    public ServletRedirector_1(HttpServletResponse response) {
        this.response = response;
    }

    public void redirect() throws Exception {
        response.sendRedirect("../home.jsp");
    }

    public static void main(String[] args) throws Exception {
        // This is a console application and does not support HTTP requests.
        // The HttpServletResponse object is typically obtained from a servlet container.
        // For demonstration purposes, we will throw an exception.
        throw new Exception("This code should be executed within a servlet container.");
    }
}