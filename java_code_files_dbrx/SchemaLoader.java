import java.lang.String;
import java.io.InputStream;

public class SchemaLoader {
    InputStream inputStream = SchemaLoader.class.getClassLoader()
                .getResourceAsStream("schema/your-schema-file");

    public static void main(String[] args) {
    }
}