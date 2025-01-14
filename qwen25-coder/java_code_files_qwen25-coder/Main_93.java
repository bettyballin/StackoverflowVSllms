public class Main {
    public static void main(String[] args) {
        // Initialize the session object
        Session session = new Session();

        // Retrieve the parameters from the session object
        String username = (String) session.getAttribute("txtUsername");
        String name = (String) session.getAttribute("txtName");
        String password = (String) session.getAttribute("txtPassword");

        // Here you can use these parameters as needed
    }
}

// Simulated Session class
class Session {
    public Object getAttribute(String key) {
        // Implement the logic to retrieve attributes as needed
        return null;
    }
}