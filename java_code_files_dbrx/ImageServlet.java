import java.lang.String;
import java.io.*;
import javax.servlet.*;

public class ImageServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        OutputStream out = null;
        InputStream in = null;
        try {
            String imagePath = "/path/to/your/cgi-bin/image.jpg"; // replace with your path
            response.setContentType("image/jpeg");
            byte[] buf = new byte[1024];
            int len = 0;
            out = response.getOutputStream();
            in = new FileInputStream(imagePath);
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
             try{out.close();}catch(Exception ignore){}
             try{in.close();}catch(Exception ignore){}
         }
    }

	public static void main(String[] args) {
	}
}