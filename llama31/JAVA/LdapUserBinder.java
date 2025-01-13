import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import java.util.Hashtable;

public class LdapUserBinder {
    public static void bindEntry(DirContext dirContext) throws Exception {
        Attributes matchAttrs = new BasicAttributes(true);
        // uid userpassword description objectclass wlsmemberof sn cn
        matchAttrs.put(new BasicAttribute("uid", "defaultuser"));
        matchAttrs.put(new BasicAttribute("userpassword", "password"));
        matchAttrs.put(new BasicAttribute("description", "defaultuser"));
        matchAttrs.put(new BasicAttribute("cn", "defaultuser"));
        matchAttrs.put(new BasicAttribute("sn", "defaultuser"));

        matchAttrs.put(new BasicAttribute("objectclass", "top"));
        matchAttrs.put(new BasicAttribute("objectclass", "person"));
        matchAttrs.put(new BasicAttribute("objectclass", "organizationalPerson"));
        matchAttrs.put(new BasicAttribute("objectclass", "inetorgperson"));
        matchAttrs.put(new BasicAttribute("objectclass", "wlsUser"));

        String name = "uid=defaultuser,ou=People,ou=ABCLdapRealm,dc=abcdomain";
        dirContext.bind(name, null, matchAttrs);
    }

    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");

        try {
            DirContext dirContext = new InitialDirContext(env);
            bindEntry(dirContext);
            dirContext.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}