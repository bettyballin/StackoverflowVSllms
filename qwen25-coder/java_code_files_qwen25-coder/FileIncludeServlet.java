import java.lang.String;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileIncludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Specify the path to your file
        String filePath = "/path/to/your/file.html";
        File file = new File(filePath);
        
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        response.setContentType("text/html");
        ServletOutputStream out = response.getOutputStream();
        java.nio.file.Files.copy(file.toPath(), out);
        out.close();
    }

	public static void main(String[] args) {
	}
}