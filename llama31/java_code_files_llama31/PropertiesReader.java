/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class PropertiesReader {
    PropertiesReader() {
    }

    public static String getInProperties(String string, String string2, String string3) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(string2);){
            properties.load(fileReader);
        }
        catch (IOException iOException) {
            System.err.println("Error reading properties file: " + iOException.getMessage());
            return null;
        }
        return properties.getProperty(string + "." + string3);
    }
}
