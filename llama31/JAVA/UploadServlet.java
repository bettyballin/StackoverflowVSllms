import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("image");
        if (filePart != null) {
            InputStream fileInputStream = filePart.getInputStream();
            // Process the file input stream
            // You can use Java's built-in File API or a library like Apache Commons IO
            // to save the file to a directory or database
            // ...
        } else {
            // Handle the case when no file is selected
            response.getWriter().println("No file selected");
        }
    }

	public static void main(String[] args) {
	}
}