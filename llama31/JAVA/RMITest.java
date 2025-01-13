import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NamingEnumeration;
import javax.naming.Binding;

public class RMITest {

    public static void main(String[] args) {
        // Load properties from file
        Properties props = new Properties();
        String propertiesFile = "path/to/your/properties/file.properties";
        try (FileInputStream fis = new FileInputStream(new File(propertiesFile))) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load properties file: " + e.getMessage());
            return;
        }

        // Set up the initial context
        Context context;
        try {
            context = new InitialContext(props);
        } catch (NamingException e) {
            System.out.println("Failed to create initial context: " + e.getMessage());
            return;
        }

        // List available services
        try {
            NamingEnumeration<Binding> bindings = context.listBindings("");
            while (bindings.hasMore()) {
                Binding binding = bindings.next();
                System.out.println(binding.getName() + ": " + binding.getClassName());
            }
        } catch (NamingException e) {
            System.out.println("Failed to list bindings: " + e.getMessage());
            return;
        }

        System.out.println("Successfully connected to RMI and listed bindings.");
    }
}