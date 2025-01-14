import java.lang.String;
import java.util.Set;

public class SecurityRolesRetrieverTest {
    public static void main(String[] args) {
        try {
            Set<String> roles = SecurityRolesRetriever.getSecurityRoles(getServletContext());
            System.out.println("Defined security roles: " + roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}