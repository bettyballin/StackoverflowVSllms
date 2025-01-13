import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the absolute path of the current Servlet
        String servletPath = getServletContext().getRealPath(request.getRequestURI());
        File servletFile = new File(servletPath);
        File servletDir = servletFile.getParentFile();

        // List the contents of the directory
        File[] files = servletDir.listFiles();
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (files != null) {
            for (File file : files) {
                out.println(file.getName());
            }
        } else {
            out.println("Directory is empty or not accessible.");
        }
        out.close();
    }
}