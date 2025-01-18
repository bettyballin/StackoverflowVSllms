import java.lang.String;
import java.lang.Integer;
import java.io.*;
import java.security.MessageDigest;
import javax.servlet.*;
import javax.servlet.http.*;

public class HashCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jarPath = "/WEB-INF/lib/PublicJar.jar";
        ServletContext context = this.getServletConfig().getServletContext();
      try (InputStream inputStream = context.getResourceAsStream(jarPath)) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[4096]; // 4 kB buffer for IO
            int read;

            while ((read = inputStream.read(buffer, 0, buffer.length)) > 0) {
                md.update(buffer, 0, read);
            }

            byte[] digest = md.digest();

             response.getWriter().print("MD5: " + toHexString(digest));
        } catch (Exception e) {}
    }

    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
	}
}