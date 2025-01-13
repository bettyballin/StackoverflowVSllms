/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapUserBinder {
    public static void bindEntry(DirContext dirContext) throws Exception {
        BasicAttributes basicAttributes = new BasicAttributes(true);
        basicAttributes.put(new BasicAttribute("uid", "defaultuser"));
        basicAttributes.put(new BasicAttribute("userpassword", "password"));
        basicAttributes.put(new BasicAttribute("description", "defaultuser"));
        basicAttributes.put(new BasicAttribute("cn", "defaultuser"));
        basicAttributes.put(new BasicAttribute("sn", "defaultuser"));
        basicAttributes.put(new BasicAttribute("objectclass", "top"));
        basicAttributes.put(new BasicAttribute("objectclass", "person"));
        basicAttributes.put(new BasicAttribute("objectclass", "organizationalPerson"));
        basicAttributes.put(new BasicAttribute("objectclass", "inetorgperson"));
        basicAttributes.put(new BasicAttribute("objectclass", "wlsUser"));
        String string = "uid=defaultuser,ou=People,ou=ABCLdapRealm,dc=abcdomain";
        dirContext.bind(string, null, (Attributes)basicAttributes);
    }

    public static void main(String[] stringArray) {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://localhost:389");
        try {
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            LdapUserBinder.bindEntry(initialDirContext);
            initialDirContext.close();
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
