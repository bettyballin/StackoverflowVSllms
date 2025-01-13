import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        try {
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            // Handle the exception
        }
    }
}