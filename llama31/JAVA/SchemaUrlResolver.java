import java.lang.String;
import java.net.URL;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class SchemaUrlResolver {
    Bundle bundle = FrameworkUtil.getBundle(SchemaUrlResolver.class);
    URL schemaUrl = bundle.getEntry("schemas/your_schema.xsd");

    public static void main(String[] args) {
    }
}