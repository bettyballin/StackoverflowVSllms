import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class CacheControlHeaderSetter {
    public void setHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    }

    public static void main(String[] args) {
        // Main method remains empty
    }
}