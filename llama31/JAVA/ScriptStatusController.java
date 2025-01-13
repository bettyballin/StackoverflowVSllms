import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptStatusController extends HttpServlet {
    private static final String FILE_PATH = "/path/to/scriptStatus.file";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scriptStatus = request.getParameter("scriptStatus");

        if (scriptStatus != null) {
            if (scriptStatus.equals("on")) {
                File file = new File(FILE_PATH + ".on");
                file.createNewFile();
                File offFile = new File(FILE_PATH + ".off");
                offFile.delete();
            } else if (scriptStatus.equals("off")) {
                File file = new File(FILE_PATH + ".off");
                file.createNewFile();
                File onFile = new File(FILE_PATH + ".on");
                onFile.delete();
            }
        }

        response.setContentType("text/html");
        response.getWriter().println("<html>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Script Status Controller</h2>");
        response.getWriter().println("<form action='' method='post'>");
        response.getWriter().println("<input type='radio' name='scriptStatus' value='on'>Enable Script<br>");
        response.getWriter().println("<input type='radio' name='scriptStatus' value='off'>Disable Script<br>");
        response.getWriter().println("<input type='submit' value='Submit'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}