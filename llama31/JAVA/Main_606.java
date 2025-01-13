import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Main_606 {
    public static void main(String[] args) {
        // Assuming you have an LdapContext object named ldapContext
        LdapContext ldapContext = null; 
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        env.put("java.naming.provider.url", "ldap://localhost:389"); // replace with your ldap server url
        try {
            ldapContext = new InitialDirContext(env);
            ldapContext.lookup(""); // There is no 'ping' method in LdapContext
            System.out.println("Connection is valid");
        } catch (NamingException e) {
            System.out.println("Connection is not valid");
        }
    }
}