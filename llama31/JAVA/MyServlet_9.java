import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet_9_9 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Generate your custom control here
        String customControl = "<div>This is a custom control</div>";
        request.setAttribute("customControl", customControl);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/my.jsp");
        dispatcher.include(request, response);
    }

    public static void main(String[] args) {
    }
}