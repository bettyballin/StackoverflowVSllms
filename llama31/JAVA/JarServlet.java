import java.lang.String;
// JarServlet.java

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String jarName = "PublicJar.jar";
        String jarPath = "/WEB-INF/lib/" + jarName;

        InputStream in = getServletContext().getResourceAsStream(jarPath);
        if (in == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.setContentType("application/java-archive");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + jarName + "\"");

        OutputStream out = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
    }

	public static void main(String[] args) {
	}
}