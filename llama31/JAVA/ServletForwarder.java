import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForwarder {
    public void forwardRequest(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("/anotherServlet");
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error forwarding request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // This main method will not be able to test the forwardRequest method
        // as it requires HttpServletRequest and HttpServletResponse objects
        // which are typically obtained from a servlet container.
        System.out.println("This is a servlet class and cannot be run as a standalone application.");
    }
}