import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import java.util.Set;

public class Main_523 {
    public static void main(String[] args) {
        // Define the composite type
        String typeName = "MyCompositeType";
        String description = "This is a composite type";
        String[] itemNames = {"name", "age"};
        String[] itemDescriptions = {"The name", "The age"};
        OpenType<?>[] itemTypes = {SimpleType.STRING, SimpleType.INTEGER};

        CompositeType compositeType = new CompositeType(typeName, description, itemNames, itemDescriptions, itemTypes);

        // Create the composite data
        Object[] itemValues = {"John Doe", 30};

        CompositeData compositeData = new CompositeDataSupport(compositeType, itemNames, itemValues);

        // Get the composite type and keys
        Set<String> keys = compositeType.keySet();

        // Print the key-value pairs
        for (String key : keys) {
            Object value = compositeData.get(key);
            System.out.println(key + "=" + value);
        }
    }
}