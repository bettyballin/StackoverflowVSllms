import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.setAttribute("decorator", "layout-main");
        try {
            getServletContext().getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public static void main(String[] args) {
    }
}