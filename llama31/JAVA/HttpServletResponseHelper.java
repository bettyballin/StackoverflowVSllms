import java.lang.String;

public class HttpServletResponseHelper {
    public static void main(String[] args) {
        // Assuming response is an HttpServletResponse object
        // Since we don't have the response object here, 
        // we'll create an instance of HttpServletResponse to make the code compile
        javax.servlet.http.HttpServletResponse response = null; 
        // You would typically get the response object from somewhere else

        if (response != null) {
            response.setHeader("Cache-Control", "no-cache, no-store");
        }
    }
}