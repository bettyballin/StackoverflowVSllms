/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import javax.naming.Binding;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class LdapServerDiscovery {
    public static void main(String[] stringArray) {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        hashtable.put("java.naming.provider.url", "ldap://");
        try {
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            NamingEnumeration<Binding> namingEnumeration = initialDirContext.listBindings("");
            while (namingEnumeration.hasMore()) {
                Binding binding = namingEnumeration.next();
                System.out.println(binding.getName());
            }
        }
        catch (NamingException namingException) {
            System.out.println("Error: " + namingException.getMessage());
        }
    }
}
