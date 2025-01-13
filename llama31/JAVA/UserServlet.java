import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// UserServlet.java
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserDao userDao; // You need to initialize this somewhere, possibly in the servlet's init method

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve users from database
        List<User> users = userDao.findAll();
        // Display users in JSP
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
    }
}