import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet_4 extends HttpServlet {
    // In MyServlet.java
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setAttribute("GmailId", this.getInitParameter("GmailId"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/yourJspPage.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}