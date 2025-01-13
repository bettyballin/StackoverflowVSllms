import java.io.File;
import java.io.IOException;

import javax.servlet.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
                 maxFileSize = 1024 * 1024 * 5, // 5 MB
                 maxRequestSize = 1024 * 1024 * 5) // 5 MB
public class FileUploadServlet_2_2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        File file = new File("path/to/permanent/location", fileName);
        filePart.write(file.getAbsolutePath());
    }

	public static void main(String[] args) {
	}
}