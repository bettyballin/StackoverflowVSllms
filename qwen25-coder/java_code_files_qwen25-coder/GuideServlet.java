import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/getGuide")
public class GuideServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/guides/pageGuide.html");
        File file = new File(path);
        resp.setContentType("text/html");
        Files.copy(file.toPath(), resp.getOutputStream());
    }

	public static void main(String[] args) {
	}
}