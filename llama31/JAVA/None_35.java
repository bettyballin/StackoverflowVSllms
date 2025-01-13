import java.lang.String;

public class None_35_35 {
    // In the first JSP page
    public static void main(String[] args) {
        // The session object is typically obtained from an HttpServletRequest object in a JSP or Servlet.
        // For the purpose of this example, we will assume that session is an object of HttpSession.
        // Since we are running this in a normal Java environment, not in a JSP or Servlet environment,
        // we cannot directly work with HttpSession objects. However, we can simulate this behavior.

        // Let's declare and initialize variables
        String _USERNAME_ = "your_username"; // replace with your actual username
        String name = "your_name"; // replace with your actual name
        String _PASSWORD_ = "your_password"; // replace with your actual password

        // Simulating session.setAttribute
        System.out.println("Simulating session.setAttribute:");
        System.out.println("txtUsername: " + _USERNAME_);
        System.out.println("txtName: " + name);
        System.out.println("txtPassword: " + _PASSWORD_);
    }
}