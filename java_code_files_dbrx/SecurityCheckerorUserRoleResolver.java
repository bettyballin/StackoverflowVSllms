import java.util.ArrayList;
import java.util.List;

public class SecurityCheckerorUserRoleResolver {
    public List<String> getUserRoles(HttpServletRequest request){
        List<String> userRoles = new ArrayList<>();
        String[] availableRoles = {"role1", "role2", "admin"}; // This could come from a database or other source of truth in your app.

        for (String role : availableRoles) {
            if(request.isUserInRole(role)) { userRoles.add(role); }
        }

        return userRoles;
    }
    public static void main(String[] args) {
    }
}

interface HttpServletRequest {
    boolean isUserInRole(String role);
}