import javax.servlet.http.HttpServletResponse;

public class HTTPRedirector {

    public void redirect(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "http://newurl.com/resource");
    }

    public static void main(String[] args) {
    }
}