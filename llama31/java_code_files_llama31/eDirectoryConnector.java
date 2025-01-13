/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class eDirectoryConnector {
    public static void main(String[] stringArray) {
        String string = "ldap://your-edirectory-server-ip:389";
        String string2 = "o=your-organization";
        String string3 = "cn=admin,o=your-organization";
        String string4 = "your-password";
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", string);
        hashtable.put("java.naming.security.authentication", "simple");
        hashtable.put("java.naming.security.principal", string3);
        hashtable.put("java.naming.security.credentials", string4);
        try {
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            initialDirContext.close();
        }
        catch (NamingException namingException) {
            namingException.printStackTrace();
        }
    }
}
