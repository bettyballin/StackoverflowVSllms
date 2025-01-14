import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Enumeration;

public class SecPayStepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        // Corrected to use getParameter instead of getAttribute
        String stepNumberStr = request.getParameter("step");
        Integer pageNumber = (stepNumberStr != null) ? Integer.parseInt(stepNumberStr) : 0;
    
        if (pageNumber != null) {
            System.out.println("page number was " + pageNumber.intValue());
            session.setAttribute("secPayStepNum", pageNumber);
        } else {
            System.out.println("page number was null");
            session.setAttribute("secPayStepNum", new Integer(0));
        }
    
        // Optional: Log all parameters for debugging
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            System.out.println("[PARAM] " + paramName + "=" + request.getParameter(paramName));
        }
    }
    
    public static void main(String[] args) {
    }
}