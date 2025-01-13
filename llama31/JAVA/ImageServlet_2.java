import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Specify the path to your image file
        String filePath = "/path/to/your/image.jpg";
        File imageFile = new File(filePath);

        // Set the MIME type for JPEG images
        response.setContentType("image/jpeg");

        // Read the image file and write it to the response output stream
        try (FileInputStream fileInputStream = new FileInputStream(imageFile);
             OutputStream outputStream = response.getOutputStream()) {

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {}
}