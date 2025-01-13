/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabasePropertiesLoader {
    public static void main(String[] stringArray) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db.properties"));
            String string = properties.getProperty("username");
            String string2 = properties.getProperty("password");
            System.out.println("Database User: " + string);
            System.out.println("Database Password: " + string2);
        }
        catch (IOException iOException) {
            System.err.println("Error loading properties file: " + iOException.getMessage());
        }
    }
}
