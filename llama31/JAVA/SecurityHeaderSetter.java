import javax.servlet.http.HttpServletResponse;

public class SecurityHeaderSetter {
    public static void main(String[] args) {
        // Note: In a real application, you would get the HttpServletResponse object from the servlet container.
        // For the sake of this example, we will create a mock HttpServletResponse object.
        HttpServletResponse response = new HttpServletResponse() {
            // Implement the HttpServletResponse methods if needed
        };

        response.setHeader("X-Frame-Options", "SAMEORIGIN");
    }
}