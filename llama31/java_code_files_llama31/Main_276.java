/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class Main_276 {
    public static void main(String[] stringArray) {
        String string = "cn=entryDN,ou=people,dc=example,dc=com";
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://localhost:389");
        hashtable.put("java.naming.security.authentication", "simple");
        hashtable.put("java.naming.security.principal", "cn=admin,dc=example,dc=com");
        hashtable.put("java.naming.security.credentials", "password");
        try {
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            initialDirContext.unbind(string);
            initialDirContext.close();
        }
        catch (NamingException namingException) {
            System.out.println("Error deleting entry: " + namingException.getMessage());
        }
    }
}
