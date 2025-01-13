import javax.servlet.http.HttpServletRequest;

public class ButtonHandler_1_1 {
    public static void main(String[] args) {
        // Simulating a HttpServletRequest for demonstration purposes
        HttpServletRequest request = null; // This would typically be injected by a servlet container

        // Assuming request is not null
        String buttonValue = request.getParameter("button");
        if (buttonValue != null) {
            if (buttonValue.equals("button1")) {
                // button1 was clicked
                System.out.println("Button 1 was clicked");
            } else if (buttonValue.equals("button2")) {
                // button2 was clicked
                System.out.println("Button 2 was clicked");
            } else if (buttonValue.equals("button3")) {
                // button3 was clicked
                System.out.println("Button 3 was clicked");
            }
        }
    }
}