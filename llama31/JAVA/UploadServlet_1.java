import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = "/uploadServlet")
@javax.servlet.annotation.MultipartConfig(fileSizeThreshold = 1024 * 1024) // 1MB
public class UploadServlet_1_1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        // Process the file (e.g., save it to a directory or database)
        // ...
        resp.setContentType("text/plain");
        resp.getWriter().println("File uploaded successfully!");
    }

    public static void main(String[] args) {
    }
}