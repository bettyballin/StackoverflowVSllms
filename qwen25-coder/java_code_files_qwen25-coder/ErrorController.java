import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class ErrorController {
    public static void main(String[] args) {
        HttpServletResponse response = null;
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}