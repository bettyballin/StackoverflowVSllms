/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_350 {
    public static void main(String[] stringArray) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/etc/myapp/db.properties"));
        }
        catch (IOException iOException) {
            System.err.println("Error loading properties file: " + iOException.getMessage());
            return;
        }
        String string = properties.getProperty("db.url");
        String string2 = properties.getProperty("db.username");
        String string3 = properties.getProperty("db.password");
        System.out.println("Database URL: " + string);
        System.out.println("Database Username: " + string2);
        System.out.println("Database Password: " + string3);
    }
}
