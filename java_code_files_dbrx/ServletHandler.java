import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ServletHandler {
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = new BufferedReader(request.getReader());
        String inputLine;
        StringBuilder text = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            text.append(inputLine);
        }
        String name = getParameterFromText(text, "name");
    }

    private String getParameterFromText(StringBuilder text, String parameterName) {
        // Dummy implementation
        return null;
    }

    public static void main(String[] args) {
    }
}

class HttpServletRequest {
    public Reader getReader() {
        return null; // Dummy implementation
    }
}

class HttpServletResponse {
    // Dummy implementation
}