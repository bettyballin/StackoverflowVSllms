import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ImageServlet_1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Path to the image
        String filePath = "/path/to/your/image.jpg";
        
        File file = new File(filePath);
        response.setContentType("image/jpeg");
        response.setContentLength((int)file.length());
        
        FileInputStream inStream = new FileInputStream(file);
        
        OutputStream outStream = response.getOutputStream();
        
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        
        inStream.close();
        outStream.close();
    }

	public static void main(String[] args) {
	}
}