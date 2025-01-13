import javax.servlet.http.HttpServletResponse;

public class HttpRedirector {
    public static void main(String[] args) throws Exception {
        String url = "URL";
        // Assuming response is an HttpServletResponse object
        HttpServletResponse response = null; // You would typically get this from a servlet container
        String encodedUrl = response.encodeURL(url);
        response.sendRedirect(encodedUrl);
    }
}