import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static void main(String[] args) {
        // The following code should be inside a method that has access to HttpSession and HttpServletRequest
        // HttpSession session = request.getSession();
        // String customId = (String) session.getAttribute("customId");
        // For demonstration purposes, the above code is commented out and replaced with a simple example
        String customId = "exampleId";
        System.out.println("Custom ID: " + customId);
    }
}