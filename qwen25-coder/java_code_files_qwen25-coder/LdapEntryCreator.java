import java.lang.String;
import javax.naming.directory.*;

public class LdapEntryCreator {
    public static void createEntry(DirContext dirContext) throws Exception {
        Attributes attrs = new BasicAttributes(true);

        // Define all attributes of the entry
        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("person");
        objClasses.add("organizationalPerson");
        objClasses.add("inetOrgPerson");
        attrs.put(objClasses);

        attrs.put(new BasicAttribute("uid", "defaultuser"));
        attrs.put(new BasicAttribute("cn", "defaultuser"));
        attrs.put(new BasicAttribute("sn", "defaultuser"));
        attrs.put(new BasicAttribute("description", "defaultuser"));

        // The userPassword should be hashed. Here is a plain example, not recommended for production.
        // For hashing, consider using libraries like BCrypt or Apache Digester.
        attrs.put(new BasicAttribute("userpassword", "{SHA}encryptedPasswordHere".getBytes()));

        // Full DN of the new entry
        String distinguishedName = "uid=defaultuser,ou=People,ou=ABCLdapRealm,dc=abcdomain";

        // Create the new entry in LDAP
        dirContext.createSubcontext(distinguishedName, attrs);
    }

    public static void main(String[] args) {
    }
}