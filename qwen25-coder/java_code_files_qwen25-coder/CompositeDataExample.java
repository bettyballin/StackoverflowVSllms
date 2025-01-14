import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;

public class CompositeDataExample {
    public static void main(String[] args) throws Exception {
        // Create item names
        String[] itemNames = {"name", "age", "city"};
        String[] itemDescriptions = {"Person's name", "Person's age", "City of residence"};
        OpenType<?>[] itemTypes = {SimpleType.STRING, SimpleType.INTEGER, SimpleType.STRING};

        // Create CompositeType
        CompositeType compositeType = new CompositeType(
                "Person",
                "Person Details",
                itemNames,
                itemDescriptions,
                itemTypes
        );

        // Create item values
        Object[] itemValues = {"John Doe", 30, "New York"};

        // Create CompositeData
        CompositeData compositeData = new CompositeDataSupport(compositeType, itemNames, itemValues);

        CompositeType type = compositeData.getCompositeType();

        // Get all keys
        for (String key : type.keySet()) {
            Object value = compositeData.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}