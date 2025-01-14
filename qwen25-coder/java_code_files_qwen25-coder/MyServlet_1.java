import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;

public class MyServlet extends HttpServlet {
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        String urlEncodedData = sb.toString();
        String[] pairs = urlEncodedData.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            if (idx > 0 && pair.substring(0, idx).equals("name")) {
                String name = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
                // Process 'name' as needed
            }
        }
    }
}

class HttpServlet {
    // Empty class for compilation purposes
}

class HttpServletRequest {
    public BufferedReader getReader() {
        // Return a dummy BufferedReader
        return new BufferedReader(new java.io.StringReader(""));
    }
}

class HttpServletResponse {
    // Empty class for compilation purposes
}