import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCharsetHandler extends AbstractHandler {
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
        response.setHeader("Content-Type", "text/plain");
        // ... rest of your code ...
    }

    public static void main(String[] args) {
    }
}