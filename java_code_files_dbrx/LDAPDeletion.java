import java.lang.String;
import netscape.ldap.*;
import javax.naming.*;
import javax.naming.directory.*;

public class LDAPDeletion {
    public static void main(String[] args) {
        // establish connection to server and bind
        LDAPConnection conn = new LDAPConnection();
        try {
            conn.connect("ldap_server", 389);               // assuming your server and port here
            conn.bind("user_dn", "password");   // replace with appropriate DN and password for the user to perform this operation

            if (conn.isAuthenticated()) {
                String objectDN = "cn=ObjectToDelete,dc=domain,dc=com";      // replace with desired DN of entry to delete
                conn.delete(objectDN);    // issue the deletion
            } else {
                System.out.println("Binding failed");
            }
        } catch (LDAPException e) {
            System.err.println(e.toString());
        } finally {
            try {
                conn.disconnect();    // close connection when finished
            } catch (LDAPException e) {
                System.err.println("Disconnection failed");
            }
        }
    }
}