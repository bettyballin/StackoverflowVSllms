import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader;
        try {
            reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Assuming the data is simply key=value pairs and not JSON or XML
        String body = sb.toString();
        if (body.contains("name=")) {
            String name = body.substring(body.indexOf("=") + 1);
            // Process 'name' as needed
        }
    }
}