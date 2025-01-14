import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Vector;

public class ForwardingServlet extends HttpServlet {

    // Assuming 'beans' is your Vector<YourBean>
    Vector<YourBean> beans = new Vector<YourBean>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("beans", beans);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/yourJspPage.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}

class YourBean {
    // Define properties and methods as needed
}