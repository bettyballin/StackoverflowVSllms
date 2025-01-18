import javax.naming.*;
import javax.naming.directory.*;

public class LdapUserBinder {
    public static void bindEntry(DirContext dirContext) throws Exception {
        Attributes matchAttrs = new BasicAttributes(true);
        // uid userPassword description objectClass sn cn
        matchAttrs.put(new BasicAttribute("uid", "defaultuser"));
        matchAttrs.put(new BasicAttribute("userPassword", "password"));
        matchAttrs.put(new BasicAttribute("description", "default user"));
        matchAttrs.put(new BasicAttribute("cn", "defaultuser"));
        matchAttrs.put(new BasicAttribute("sn", "defaultuser"));

        // Change it to a suitable objectClass based on LDAP server schema.
        matchAttrs.put(new BasicAttribute("objectClass", "top"));
        matchAttrs.put(new BasicAttribute("objectClass", "person"));
        matchAttrs.put(new BasicAttribute("objectClass", "organizationalPerson"));
        matchAttrs.put(new BasicAttribute("objectClass", "inetOrgPerson"));
        // matchAttrs.put(new BasicAttribute("objectClass", "wlsmemberOf"));

        // Create the distinguished name
        Name dn = new CompositeName().add("uid=defaultuser");

        InitialDirContext iniDirContext = (InitialDirContext) dirContext;
        iniDirContext.bind(dn, null, matchAttrs); // Use bind(Name name, Object obj, Attributes attrs)
    }

    public static void main(String[] args) {
        // You can add code here to obtain a DirContext and call bindEntry if needed.
    }
}