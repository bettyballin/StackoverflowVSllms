import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ButtonHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String buttonValue = request.getParameter("button");
        if ("Button 1".equals(buttonValue)) {
            // Button 1 was clicked
        } else if ("Button 2".equals(buttonValue)) {
            // Button 2 was clicked
        }
    }

    public static void main(String[] args) {
    }
}