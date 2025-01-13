import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

public class Main_607 {
    public static void main(String[] args) {
        // Assuming you have a DirContext object named dirContext
        DirContext dirContext;
        try {
            Properties env = new Properties();
            env.put("java.naming.provider.url", "ldap://localhost:389");
            dirContext = new InitialDirContext(env);
        } catch (NamingException e) {
            System.out.println("Error creating DirContext");
            return;
        }

        try {
            NamingEnumeration<?> enumeration = dirContext.list("");
            if (enumeration.hasMore()) {
                System.out.println("Connection is valid");
            } else {
                System.out.println("Connection is not valid");
            }
        } catch (NamingException e) {
            System.out.println("Connection is not valid");
        }
    }
}