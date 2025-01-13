/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptStatusController
extends HttpServlet {
    private static final String FILE_PATH = "/path/to/scriptStatus.file";

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String string = httpServletRequest.getParameter("scriptStatus");
        if (string != null) {
            if (string.equals("on")) {
                File file = new File("/path/to/scriptStatus.file.on");
                file.createNewFile();
                File file2 = new File("/path/to/scriptStatus.file.off");
                file2.delete();
            } else if (string.equals("off")) {
                File file = new File("/path/to/scriptStatus.file.off");
                file.createNewFile();
                File file3 = new File("/path/to/scriptStatus.file.on");
                file3.delete();
            }
        }
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<html>");
        httpServletResponse.getWriter().println("<body>");
        httpServletResponse.getWriter().println("<h2>Script Status Controller</h2>");
        httpServletResponse.getWriter().println("<form action='' method='post'>");
        httpServletResponse.getWriter().println("<input type='radio' name='scriptStatus' value='on'>Enable Script<br>");
        httpServletResponse.getWriter().println("<input type='radio' name='scriptStatus' value='off'>Disable Script<br>");
        httpServletResponse.getWriter().println("<input type='submit' value='Submit'>");
        httpServletResponse.getWriter().println("</form>");
        httpServletResponse.getWriter().println("</body>");
        httpServletResponse.getWriter().println("</html>");
    }
}
