import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public final class HttpServletHelper {
    private HttpServletHelper() {} // Prevent instantiation of utility class

    public static String getBody(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = request.getReader()) {
            char[] buffer = new char[1024];
            for (int length; (length = bufferedReader.read(buffer)) != -1; ) {
                stringBuilder.append(buffer, 0, length);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
    }
}