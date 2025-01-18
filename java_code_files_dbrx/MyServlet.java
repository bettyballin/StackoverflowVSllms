import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyServlet {
    public void processRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String myParam = (String) session.getAttribute("myParam");
        // You can now use `${myParam}` if JSP EL is enabled, or `<%= myParam %>` for direct access
    }
}