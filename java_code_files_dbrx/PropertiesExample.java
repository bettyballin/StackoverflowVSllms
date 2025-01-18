import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) {
        String propertiesFile = "path/to/your/properties"; // e.g., ./mypluginthatrocks/myawesomeproerties.propetries
        String propKey = "property-key";
        Path filePath = Paths.get(propertiesFile);
        Properties props = new Properties();

        if (Files.exists(filePath)) {
            try (InputStream input = Files.newInputStream(filePath, StandardOpenOption.READ)) {
                props.load(input); // Load the properties from the file to a java.util.Properties instance

                String propValue = getPropertyFromFile(props, propKey);
                if (!propValue.equals("")) {
                    System.out.println("Property with key [" + propKey + "] has value: " + propValue);
                } else {
                    setPropertyInFile(props, propKey, "new_value", filePath); // Set the property in the file itself
                }
            } catch (IOException e) {
                System.err.println("Error reading or writing to properties file: " + e.getMessage());
            }
        } else {
            throw new RuntimeException(propertiesFile + " does not exist.");
        }
    }

    // Methods for get/set property from file
    public static String getPropertyFromFile(Properties props, String key) {
        return props.getProperty(key); // You can add more logic to handle properties that don't exist in the file
    }

    public static void setPropertyInFile(Properties props, String key, String value, Path pathToPropertiesFile) throws IOException {
        try (OutputStream output = Files.newOutputStream(pathToPropertiesFile, StandardOpenOption.APPEND)) { // StandardOpenOption.TRUNCATE_EXISTING for overwriting the existing properties in file
            props.setProperty(key, value); // Sets a new property to your Properties instance -> this should be done BEFORE saving it to a Stream.
            props.store(output, "Updated Property"); // Save changes to the properties and write them to output stream.
        } catch (IOException e) {
            System.err.println("Error writing to properties file: " + e.getMessage());
        }
    }
}