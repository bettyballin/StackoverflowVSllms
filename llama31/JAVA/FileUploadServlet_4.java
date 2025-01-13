import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;

public class FileUploadServlet_4_4 extends HttpServlet {
    private static final int MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        if (filePart.getSize() > MAX_FILE_SIZE) {
            // Handle error: file is too large
        }
    }

    public static void main(String[] args) {
    }
}