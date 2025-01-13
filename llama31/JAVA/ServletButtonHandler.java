import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletButtonHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("button1") != null) {
            // Button 1 was clicked
        } else if (request.getParameter("button2") != null) {
            // Button 2 was clicked
        }
    }

    public static void main(String[] args) {
    }
}