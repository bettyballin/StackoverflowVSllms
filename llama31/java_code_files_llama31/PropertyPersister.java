/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyPersister {
    public static void main(String[] stringArray) {
        Properties properties = new Properties();
        properties.put("lastOpenedFile", "/path/to/file");
        try (FileOutputStream fileOutputStream = new FileOutputStream("app.properties");){
            properties.store(fileOutputStream, null);
        }
        catch (IOException iOException) {
            System.err.println("Error storing properties: " + iOException.getMessage());
        }
    }
}
