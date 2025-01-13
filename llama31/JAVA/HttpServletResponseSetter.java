import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseSetter {
    public static void main(String[] args) {
        HttpServletResponse response = null; // You would need to get an instance of HttpServletResponse from a Servlet or similar
        // For demonstration purposes, let's assume we have a valid HttpServletResponse object
        if (response != null) {
            response.setHeader("Content-Type", "text/plain");
            response.setCharacterEncoding(null);
        } else {
            System.out.println("No HttpServletResponse instance available.");
        }
    }
}