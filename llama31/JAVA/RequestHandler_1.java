import javax.servlet.http.HttpServletRequest;

public class RequestHandler_1_1 {
    public void handleRequest(HttpServletRequest request) {
        if (request.getParameter("confirm") != null) {
            // Confirm button was used, do DB tasks and redirect
        } else if (request.getParameter("cancel") != null) {
            // Cancel button was used, redirect without doing DB tasks
        }
    }

    public static void main(String[] args) {
        // This main method is not being used in this context
        // As HttpServletRequest is required to test the handleRequest method
    }
}