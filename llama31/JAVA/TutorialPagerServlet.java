import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TutorialPagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<Tutorials> tutorials = (Set<Tutorials>) request.getAttribute("tut_lst");
        request.setAttribute("tut_lst", tutorials);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<pg:pager>");
        out.println("<pg:param name='keywords'/>");

        for (Tutorials t : tutorials) {
            out.println("<pg:item>");
            out.println("<br><a href='down?tid=" + t.getUploadid() + "'>" + t.getFilename() + "</a>");
            out.println("</pg:item>");
        }

        out.println("<pg:index>");
        out.println("<pg:first>");
        out.println("<a href='" + request.getRequestURL() + "'>[ (" + request.getParameter("pageNumber") + ") |&lt; Previous ]</a>");
        out.println("</pg:first>");

        out.println("<pg:prev>");
        out.println("<a href='" + request.getRequestURL() + "'>[ (" + request.getParameter("pageNumber") + ") &lt;&lt; Previous ]</a>");
        out.println("</pg:prev>");

        out.println("<pg:pages>");
        out.println("<a href='" + request.getRequestURL() + "'>" + request.getParameter("pageNumber") + "</a>");
        out.println("</pg:pages>");

        out.println("<pg:next>");
        out.println("<a href='" + request.getRequestURL() + "'>[ Next &gt;&gt; (" + request.getParameter("pageNumber") + ") ]</a>");
        out.println("</pg:next>");

        out.println("<pg:last>");
        out.println("<a href='" + request.getRequestURL() + "'>[ Last &gt;| (" + request.getParameter("pageNumber") + ") ]</a>");
        out.println("</pg:last>");
        out.println("</pg:index>");
        out.println("</pg:pager>");
        out.println("</body>");
        out.println("</html>");
    }
}