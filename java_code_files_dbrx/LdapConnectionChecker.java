import javax.naming.NamingException;
import javax.naming.directory.DirContext;

public class LdapConnectionChecker {
    public boolean isConnected(DirContext ctx) throws NamingException {
        // Attempt to retrieve the root DSE. This is just a shortcut for seeing if we are connected
        // If we are able to get attributes, then our connection must be valid so return true
        try {
            if (ctx.getAttributes("") != null) {
                return true;
            } else {
                throw new NamingException();
            }
        } catch (NamingException e) {
            // If here, then the context is not connected / already closed -- so we should return false
            return false;
        }
    }

    public static void main(String[] args) {
    }
}