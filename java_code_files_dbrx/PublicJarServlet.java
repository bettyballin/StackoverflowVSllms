import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PublicJarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletConfig().getServletContext();
        String jarPath = "/WEB-INF/lib/PublicJar.jar";
        InputStream inputStream = context.getResourceAsStream(jarPath);

        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + request.getAttribute("filename") + "");

        try (OutputStream outputStream = response.getOutputStream()) {
            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

	public static void main(String[] args) {
	}
}