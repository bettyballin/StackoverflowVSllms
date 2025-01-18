import java.util.*;
import java.io.*;
import javax.naming.*;
import javax.naming.spi.InitialContextFactory;

public class Test {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream fin = new FileInputStream("config.properties")) {
            props.load(fin);
        } catch (IOException e) {
            // Handle the exception as needed, e.g., by throwing an unchecked exception
            throw new RuntimeException(e);
        }

        String initialContextFactory = props.getProperty("java.naming.factory.initial");
        InitialContextFactory contextFactory;
        try {
            Class<?> clazz = Class.forName(initialContextFactory);
            contextFactory = (InitialContextFactory) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            // Handle the exception as needed, e.g., by throwing an unchecked exception
            throw new RuntimeException(e);
        }

        InitialContext ictx;
        try {
            ictx = (InitialContext) contextFactory.getInitialContext(props);
        } catch (NamingException e) {
            // Handle the exception as needed, e.g., by throwing an unchecked exception
            throw new RuntimeException(e);
        }

        // You can perform operation to check if you are able to fetch any service or not.
        try {
            ictx.list("");
        } catch (NamingException ex) {
            // Handle the exception as needed, e.g., by throwing an unchecked exception
            throw new RuntimeException(ex);
        }

        // If we are here then RMI is working and naming service can provide names from this context.
        System.out.println("RMI connection established !!");
    }
}