import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController_8_8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException {
        // Logic goes here
        String name = req.getParameter("name");
        req.setAttribute("name", name);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
    }
}