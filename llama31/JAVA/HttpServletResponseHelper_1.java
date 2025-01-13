import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseHelper_1_1 {
    HttpServletResponse response;

    public HttpServletResponseHelper_1(HttpServletResponse response) {
        this.response = response;
    }

    public void setHeader() {
        response.setHeader("Expires", "-1");
    }

    public static void main(String[] args) {
        // You would need an instance of HttpServletResponse to use this class.
        // For example, in a Servlet:
        // HttpServletResponseHelper_1 helper = new HttpServletResponseHelper_1(response);
        // helper.setHeader();
    }
}