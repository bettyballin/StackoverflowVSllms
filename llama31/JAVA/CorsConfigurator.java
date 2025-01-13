import java.lang.String;

public class CorsConfigurator {
    public static void main(String[] args) {
        // The following line should be inside a method and 'response' should be an HttpServletResponse object
        // For demonstration purposes, we will use a dummy HttpServletResponse object
        javax.servlet.http.HttpServletResponse response = null;
        // You need to get an instance of HttpServletResponse to set the header
        // For example, in a Servlet, you would get it as a method parameter in the doGet or doPost methods
        if (response != null) {
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }
    }
}