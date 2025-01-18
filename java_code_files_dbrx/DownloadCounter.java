import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadCounter extends HttpServlet {
  private int downloadCount = 0;
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (request.getPathInfo().equals("/foo.zip")) {
          // Increment the count
          downloadCount++;
          try (PrintWriter out = response.getWriter()) {
              File file = new File("path_to_your_file_directory" + "/foo.zip");
              if (!file.exists() || !file.canRead()){
                  throw new ServletException("File foo.zip is missing or cannot be read.");
              }
              response.setContentType(getServletContext().getMimeType(request.getPathInfo()));
              response.setHeader("Content-Disposition", "attachment;filename=\"foo.zip\"");
              byte[] buffer = new byte[1024];
              try (FileInputStream inputStream = new FileInputStream(file)) {
                  ServletOutputStream outputStream = response.getOutputStream();
                  for (int length=0; (length = inputStream.read(buffer)) > 0;) {
                      outputStream.write(buffer, 0, length);
                  }
              } // The streams will be closed automatically here because we are using try-with-resources
          } catch (Exception ex) {
              request.setAttribute("error", "Error");
          }
      } else {
         // Handle other requests or file paths not equal to "/foo.zip"
      }
  }

	public static void main(String[] args) {
	}
}