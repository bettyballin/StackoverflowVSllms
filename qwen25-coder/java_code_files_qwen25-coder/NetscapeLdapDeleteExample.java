import java.lang.String;
import netscape.ldap.LDAPConnection;
import netscape.ldap.LDAPException;

public class NetscapeLdapDeleteExample {
    public static void main(String[] args) {
        // LDAP server details
        String ldapHost = "ldap.example.com";
        int ldapPort = 389;
        String adminDN = "cn=admin,dc=example,dc=com";
        String password = "adminpassword";

        // DN of the entry to delete
        String dnToDelete = "uid=john.doe,ou=users,dc=example,dc=com";

        LDAPConnection ldapConn = new LDAPConnection();

        try {
            // Connect to the LDAP server with administrative credentials
            ldapConn.connect(ldapHost, ldapPort);
            ldapConn.authenticate(adminDN, password);

            // Delete the specified entry
            ldapConn.delete(dnToDelete);

            System.out.println("LDAP entry deleted successfully.");
        } catch (LDAPException e) {
            System.err.println("Failed to delete LDAP entry: " + e.getMessage());
        } finally {
            try {
                if (ldapConn.isConnected()) {
                    ldapConn.disconnect();
                }
            } catch (LDAPException e) {
                System.err.println("Error disconnecting from LDAP server: " + e.getMessage());
            }
        }
    }
}