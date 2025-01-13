import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class RedirectHandler {
    String url = "URL";
    HttpServletResponse response;

    public RedirectHandler(HttpServletResponse response) {
        this.response = response;
    }

    public void sendRedirect() throws java.io.IOException {
        String encodedUrl = response.encodeRedirectURL(url);
        response.sendRedirect(encodedUrl);
    }

    public static void main(String[] args) {
        // This main method will not work as expected because it's missing the 
        // HttpServletResponse object which is typically obtained from a servlet container.
        // This code is meant to be used within a servlet or a similar context.
    }
}