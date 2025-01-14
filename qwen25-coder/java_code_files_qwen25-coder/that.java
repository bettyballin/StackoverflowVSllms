import java.lang.String;

public class that {
    // In the first JSP where you create your database object
    public static void main(String[] args) {
        HttpSession session = new HttpSession();
        DatabaseConnection dbConnection = new DatabaseConnection(); // Your class that manages connections
        session.setAttribute("dbConnection", dbConnection);
        
        // In another JSP, retrieve the object from the session
        DatabaseConnection dbConnection2 = (DatabaseConnection) session.getAttribute("dbConnection");
    }
}

class HttpSession {
    private java.util.HashMap<String, Object> attributes = new java.util.HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

class DatabaseConnection {
    // Your class that manages database connections
}