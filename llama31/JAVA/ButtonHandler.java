import javax.servlet.http.HttpServletRequest;

public class ButtonHandler {
    public static void handleButton(HttpServletRequest request) {
        if (request.getParameter("button1") != null) {
            System.out.println("button1 was clicked");
        } else if (request.getParameter("button2") != null) {
            System.out.println("button2 was clicked");
        } else if (request.getParameter("button3") != null) {
            System.out.println("button3 was clicked");
        }
    }

    public static void main(String[] args) {
        // You need to create an HttpServletRequest object to test the handleButton method
        // For example:
        // HttpServletRequest request = ...;
        // ButtonHandler.handleButton(request);
    }
}