import java.lang.String;
import java.lang.Integer;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class SecondPaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String stepNumber = request.getParameter("step");

        if (stepNumber != null){
            System.out.println("page number was "+ stepNumber);
            session.setAttribute("secPayStepNum", Integer.parseInt(stepNumber));
        } else {
            System.out.println("page number was null");
            session.setAttribute("secPayStepNum", new Integer(0));
        }   
    }

    public static void main(String[] args) {
    }
}