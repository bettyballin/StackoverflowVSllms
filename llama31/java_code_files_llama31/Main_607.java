/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class Main_607 {
    public static void main(String[] stringArray) {
        InitialDirContext initialDirContext;
        Object object;
        try {
            object = new Properties();
            ((Properties)object).put("java.naming.provider.url", "ldap://localhost:389");
            initialDirContext = new InitialDirContext((Hashtable<?, ?>)object);
        }
        catch (NamingException namingException) {
            System.out.println("Error creating DirContext");
            return;
        }
        try {
            object = initialDirContext.list("");
            if (object.hasMore()) {
                System.out.println("Connection is valid");
            } else {
                System.out.println("Connection is not valid");
            }
        }
        catch (NamingException namingException) {
            System.out.println("Connection is not valid");
        }
    }
}
