import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet("/PathToYourServlet") // Replace with your servlet path
public class MyServlet_5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String attributeName = request.getParameter("newAttribute");
        if (attributeName != null && !attributeName.equals("")) {
            String attributeValue = request.getParameter("value"); // You need to pass 'value' as a parameter from the client-side code, e.g., URLSearchParams.append('value', your_value);
            request.getSession().setAttribute(attributeName, attributeValue);
        }
        response.setStatus(204); // No Content
    }

    public static void main(String[] args) {
    }
}