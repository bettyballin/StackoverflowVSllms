import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;

@WebServlet(name = "IPNServlet", urlPatterns = {"/ipn"}, method = { RequestMethod.POST })
public class IPNServlet extends HttpServlet {
    // ...

    public static void main(String[] args) {
    }
}