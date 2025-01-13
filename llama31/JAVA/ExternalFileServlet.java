import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExternalFileServlet extends HttpServlet {
    private static final String FILE_PATH = "/path/to/external/file.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            fis.close();
            os.close();
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

	public static void main(String[] args) {
	}
}