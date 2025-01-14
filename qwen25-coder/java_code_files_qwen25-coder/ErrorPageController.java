import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageController {
    HttpServletResponse response;

    {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    public static void main(String[] args) {
    }
}