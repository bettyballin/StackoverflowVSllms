/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_349 {
    public static void main(String[] stringArray) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db.properties"));
            String string = properties.getProperty("db.url");
            String string2 = properties.getProperty("db.username");
            String string3 = properties.getProperty("db.password");
            System.out.println("DB URL: " + string);
            System.out.println("DB Username: " + string2);
            System.out.println("DB Password: " + string3);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
