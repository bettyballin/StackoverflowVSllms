import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PaymentStepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String pageNumberStr = request.getParameter("stepNumber");
        if (pageNumberStr != null){
             System.out.println("page number was "+ Integer.parseInt(pageNumberStr));
             session.setAttribute("secPayStepNum", Integer.parseInt(pageNumberStr));
        } else {
             System.out.println("page number was null");
             session.setAttribute("secPayStepNum", 0);
         }
    }

    public static void main(String[] args) {
    }
}