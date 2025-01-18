import java.lang.String;
class UserManager { // Bad design: Non-final, vulnerable to inheritance hijacking.
    public void addUser(String username, String password) {
        /* Add user code */
        if (username.equals("hacker")) {
            giveAdminRights(); // This is bad!
        }
    }

    public void giveAdminRights() {
        // Grant admin rights
    }
}
public class MaliciousUserManager extends UserManager { // The attacker's custom subclass...
    @Override
    public void addUser(String username, String password) { // Overrides original behavior.
        /* Always give admin rights */
        super.giveAdminRights();
        // Other malicious actions....
    }

    public static void main(String[] args) {
    }
}