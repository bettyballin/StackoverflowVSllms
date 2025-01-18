import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.naming.*;
import javax.naming.directory.*;

public class AddMultipleAttr {
    public static void main(String[] args) throws Exception{
        // create environment and get LDAP context
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        InitialDirContext ctx = new InitialDirContext(env);
    
        // Define DN and attributes
        String entryDN = "cn=user1,ou=sample";
        HashMap<String, Object> attrSet = new HashMap<>();
    
        // Add multiple attributes with values (this can be expanded to add more)
        attrSet.put("description", "This is an example description.");
        attrSet.put("description", Arrays.asList(
                    new String[]{"Another Description1.", "Another Example2."}));
    
        // Create list of ModificationItem and add attributes to the DN entry using `modifyAttributes()` method
        List<ModificationItem> mods = new ArrayList<>();
        for (String attrType: attrSet.keySet()) {  // loop over all types of attribute
            Attribute attr = new BasicAttribute(attrType, attrSet.get(attrType));  // create an LDAP Attribute using the type and value from attributes hashmap
            mods.add(new ModificationItem(DirContext.ADD_ATTRIBUTE, attr));  // ADD_ATTRIBUTE to signify we're adding a new attribute
        }
        ctx.modifyAttributes(entryDN, mods.toArray(new ModificationItem[0]));
        ctx.close();
    }
}