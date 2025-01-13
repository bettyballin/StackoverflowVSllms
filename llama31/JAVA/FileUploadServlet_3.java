import java.lang.String;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// Java example using Servlet API
@WebServlet("/upload")
public class FileUploadServlet_3_3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Part[] files = req.getParts();
        for (Part file : files) {
            // Process each uploaded file
        }
    }

	public static void main(String[] args) {
	}
}