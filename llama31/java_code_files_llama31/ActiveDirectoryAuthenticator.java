/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class ActiveDirectoryAuthenticator {
    public static boolean authenticate(String string, String string2, String string3) {
        Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://" + string3);
        hashtable.put("java.naming.security.authentication", "simple");
        hashtable.put("java.naming.security.principal", string + "@" + string3);
        hashtable.put("java.naming.security.credentials", string2);
        try {
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            initialDirContext.close();
            return true;
        }
        catch (NamingException namingException) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        String string = "fun.xyz.tld";
        String string2 = "testu";
        String string3 = "testp";
        boolean bl = ActiveDirectoryAuthenticator.authenticate(string2, string3, string);
        System.out.println(bl);
    }
}
