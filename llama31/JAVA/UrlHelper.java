import javax.servlet.http.HttpServletRequest;

public class UrlHelper {
    public static String getContextUrl(HttpServletRequest request, String path) {
        return request.getContextPath() + path;
    }

    public static void main(String[] args) {
    }
}