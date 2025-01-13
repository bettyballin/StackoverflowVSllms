/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigExample {
    public static void main(String[] stringArray) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("config.properties")));
        String string = properties.getProperty("username");
        String string2 = properties.getProperty("password");
        System.out.println("User name: " + string);
        System.out.println("Password: " + string2);
    }
}
