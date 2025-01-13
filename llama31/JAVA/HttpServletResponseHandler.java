import java.lang.String;

public class HttpServletResponseHandler {
    public static void main(String[] args) {
        HttpServletResponse response = null; // You need to initialize this variable
        // For example, in a Servlet environment, you would get this from HttpServletRequest
        // response = ((HttpServletRequest) req).getResponse();

        if (response != null) {
            response.setContentType("application/yaml");
        }
    }
}