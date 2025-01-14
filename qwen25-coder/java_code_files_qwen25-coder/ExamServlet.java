import java.lang.String;
// ExamServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (request.getParameter("action") != null && "start".equals(request.getParameter("action"))) {
            // Start of exam
            session.setAttribute("examStartTime", System.currentTimeMillis());
        } else if (request.getParameter("action") != null && "getTime".equals(request.getParameter("action"))) {
            // Retrieve the elapsed time
            Long startTime = (Long) session.getAttribute("examStartTime");
            if (startTime != null) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = (currentTime - startTime) / 1000; // Convert milliseconds to seconds
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.print(elapsedTime);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

	public static void main(String[] args) {
	}
}