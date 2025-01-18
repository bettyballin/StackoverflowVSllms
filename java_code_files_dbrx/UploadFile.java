import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
public class UploadFile extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException  {

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = getFileName(filePart); // Extracts file name from HTTP header content-disposition
        InputStream fileContent = filePart.getInputStream();  // ... then upload the file to your desired location using this input stream...
   }

   private String getFileName(Part part) {
       String contentDisp = part.getHeader("content-disposition");
       String[] tokens = contentDisp.split(";");
       for (String token : tokens) {
           if (token.trim().startsWith("filename")) {
               return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
           }
       }
       return "";
   }

   public static void main(String[] args) {
   }
}