import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryStringDecoder extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decodedURL = request.getQueryString(); // returns full original encoded query part (including % encoding for special characters)
    }
    public static void main(String[] args) {
    }
}