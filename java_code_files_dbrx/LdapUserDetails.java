import java.security.Principal;

public class LdapUserDetails implements Principal {
    private String username;
    private String displayName;

    public LdapUserDetails(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }

    @Override
    public String getName() {
        return this.username;
    }

    // Other methods for accessing user details as required

    public String getDisplayName() {
        return this.displayName;
    }

    public static void main(String[] args) {
        // You can test the class here
    }
}