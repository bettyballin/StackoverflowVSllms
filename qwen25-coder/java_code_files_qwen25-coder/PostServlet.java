import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/postExample")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String requestBody = sb.toString();

        // Now you can process the entire request body as a single string.
        System.out.println("Request Body: " + requestBody);

        // Example: Assuming JSON, deserialize it if necessary
        // Gson gson = new Gson();
        // MyObject myObject = gson.fromJson(requestBody, MyObject.class);
    }

	public static void main(String[] args) {
	}
}