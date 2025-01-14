import java.lang.String;
import javax.servlet.http.HttpServletResponse;

public class CORSHeadersSetter {
    public void setHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*"); // Adjust this to your needs
    }

    public static void main(String[] args) {
    }
}