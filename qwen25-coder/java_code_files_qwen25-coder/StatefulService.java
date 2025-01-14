import java.lang.String;
import java.lang.Integer;
import javax.servlet.http.*;
import java.io.IOException;

public class StatefulService extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("counter", counter);
        try {
            response.getWriter().println("Counter: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
	}
}