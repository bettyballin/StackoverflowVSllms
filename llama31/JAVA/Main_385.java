import java.net.URI;
import java.net.URISyntaxException;

// Mock HttpServletRequest for demonstration purposes
class HttpServletRequestMock {
    public String getServletPath() {
        return "/servletPath";
    }

    public String getPathInfo() {
        return "/pathInfo";
    }

    public String getQueryString() {
        return "queryString";
    }
}

public class Main_385 {
    public static void main(String[] args) {
        HttpServletRequestMock request = new HttpServletRequestMock();

        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String queryString = request.getQueryString();

        try {
            URI uri = new URI(null, null, servletPath + pathInfo, queryString, null);
            String undecodedUrl = uri.getRawPath() + "?" + uri.getRawQuery();
            System.out.println(undecodedUrl); // Use the undecodedUrl
        } catch (URISyntaxException e) {
            System.err.println("URISyntaxException caught: " + e.getMessage()); // Handle the exception
        }
    }
}