/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.naming.Binding;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class RMITest {
    public static void main(String[] stringArray) {
        Object object;
        Properties properties = new Properties();
        String string = "path/to/your/properties/file.properties";
        try {
            object = new FileInputStream(new File(string));
            try {
                properties.load((InputStream)object);
            }
            finally {
                ((FileInputStream)object).close();
            }
        }
        catch (IOException iOException) {
            System.out.println("Failed to load properties file: " + iOException.getMessage());
            return;
        }
        try {
            object = new InitialContext(properties);
        }
        catch (NamingException namingException) {
            System.out.println("Failed to create initial context: " + namingException.getMessage());
            return;
        }
        try {
            NamingEnumeration<Binding> namingEnumeration = object.listBindings("");
            while (namingEnumeration.hasMore()) {
                Binding binding = namingEnumeration.next();
                System.out.println(binding.getName() + ": " + binding.getClassName());
            }
        }
        catch (NamingException namingException) {
            System.out.println("Failed to list bindings: " + namingException.getMessage());
            return;
        }
        System.out.println("Successfully connected to RMI and listed bindings.");
    }
}
