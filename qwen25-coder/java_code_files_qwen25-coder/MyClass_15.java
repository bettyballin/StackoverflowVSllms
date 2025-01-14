import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyClass {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream schemaStream = MyClass.class.getResourceAsStream("/schemas/your-schema.xsd");
        if (schemaStream == null) {
            throw new FileNotFoundException("Schema file not found in resources.");
        }
        // Use schemaStream for validation...
    }
}