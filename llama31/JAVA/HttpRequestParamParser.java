import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestParamParser {
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        try (InputStream in = request.getInputStream()) {
            String body = new String(in.readAllBytes());
            // parse the body manually
            String[] params = body.split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2 && keyValue[0].equals("name")) {
                    String name = keyValue[1];
                    // use the name parameter
                }
            }
        } catch (IOException e) {
            // handle exception
        }
    }

    public static void main(String[] args) {
    }
}