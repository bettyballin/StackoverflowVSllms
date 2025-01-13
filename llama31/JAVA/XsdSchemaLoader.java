import java.lang.String;
import java.net.URL;

public class XsdSchemaLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = XsdSchemaLoader.class.getClassLoader();
        URL schemaUrl = classLoader.getResource("schemas/your_schema.xsd");
    }
}