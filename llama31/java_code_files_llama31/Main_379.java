/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_379 {
    public static void main(String[] stringArray) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("path/to/config.properties"));
            String string = properties.getProperty("soap.endpoint");
            System.out.println(string);
        }
        catch (IOException iOException) {
            System.err.println("Error loading properties file: " + iOException.getMessage());
        }
    }
}
