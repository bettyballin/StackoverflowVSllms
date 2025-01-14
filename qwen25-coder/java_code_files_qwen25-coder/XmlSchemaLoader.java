import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class XmlSchemaLoader {
    public static void main(String[] args) {
        try (InputStream schemaStream = XmlSchemaLoader.class.getResourceAsStream("/schemas/your-schema.xsd")) {
            if (schemaStream == null) {
                throw new FileNotFoundException("Schema file not found in resources.");
            }
            // Further processing or validation using schemaStream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}