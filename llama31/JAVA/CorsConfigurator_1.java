import javax.servlet.http.HttpServletResponse;

public class CorsConfigurator_1_1 {
    public static void setCorsHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    public static void main(String[] args) {
        // You can't directly set the header here.
        // You need to get the HttpServletResponse object from somewhere.
        // For example, in a Servlet, you would do something like this:
        // HttpServletResponse response = getServletResponseSomehow();
        // setCorsHeader(response);
    }
}