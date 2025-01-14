import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alternate-uri")
public class AlternateUriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Define the canonical URI
        String canonicalURI = "/canonical-uri";

        // Send a 302 redirect to the canonical URI
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", canonicalURI);

        // Optionally, you can set some content in the response body
        response.getWriter().println("This resource has moved temporarily. Please use " + canonicalURI);
    }

	public static void main(String[] args) {
	}
}