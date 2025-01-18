import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ButtonHandlerServlet {

    public void handleRequest(HttpServletRequest request) throws ServletException {
        String confirmButton = request.getParameter("confirmButton");
        String cancelButton = request.getParameter("cancelButton");

        if ("Confirm".equals(confirmButton)) {
            // DB tasks and redirect
        } else if ("Cancel".equals(cancelButton)) {
            // Just redirect to the same page
        } else {
            throw new ServletException("Unexpected value: " + confirmButton);
        }
    }

    public static void main(String[] args) {
    }
}