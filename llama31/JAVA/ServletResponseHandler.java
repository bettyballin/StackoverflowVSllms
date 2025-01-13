import javax.servlet.http.HttpServletResponse;

public class ServletResponseHandler {
    HttpServletResponse response;

    public ServletResponseHandler(HttpServletResponse response) {
        this.response = response;
    }

    public void handleResponse() {
        response.flushBuffer();
    }

    public static void main(String[] args) {
        // You cannot run this class directly as it requires an HttpServletResponse object.
        // This class is intended to be used in a Servlet-based web application.
    }
}