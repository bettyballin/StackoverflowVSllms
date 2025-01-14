import java.util.List;
import java.util.ArrayList;

public class RoleManager {

    public static void main(String[] args) {
        // Assuming resultSet is populated with roles from the database
        ResultSet resultSet = new ResultSet();
        Session session = new Session();

        // When setting the session after login
        List<String> userRoles = new ArrayList<>();

        while (resultSet.next()) {
            String role = resultSet.getString("ROLE_ID");
            userRoles.add(role);
        }
        session.setAttribute("userRoles", userRoles);

        // On each page, when checking permissions
        List<String> roles = (List<String>) session.getAttribute("userRoles");
        if (roles != null && roles.contains("requiredRole")) {
            // User has the required role, allow access
        } else {
            // User does not have the required role, deny access
        }
    }
}

class ResultSet {
    int index = 0;
    String[] roles = {"admin", "user"};

    boolean next() {
        if (index < roles.length) {
            index++;
            return true;
        } else {
            return false;
        }
    }

    String getString(String columnLabel) {
        // Return the role at the current index minus one (since index was incremented)
        return roles[index - 1];
    }
}

class Session {
    java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    Object getAttribute(String name) {
        return attributes.get(name);
    }
}