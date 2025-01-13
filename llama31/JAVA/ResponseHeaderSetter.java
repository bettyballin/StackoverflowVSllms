import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderSetter {
    public static void setResponseHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
    }

    public static void main(String[] args) {
        // You would need a servlet container like Apache Tomcat to run this code.
        // For the sake of making it compilable, I'm leaving the main method blank.
    }
}