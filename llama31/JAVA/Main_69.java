import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

public class Main_69 {
    public static void main(String[] args) {
        // Create a new BasicAttributes object
        BasicAttributes attributes = new BasicAttributes();

        // Create a new BasicAttribute object for the description attribute
        BasicAttribute descriptionAttribute = new BasicAttribute("description");

        // Add two values to the description attribute
        descriptionAttribute.add("This is the first description");
        descriptionAttribute.add("This is the second description");

        // Add the description attribute to the attributes object
        attributes.put(descriptionAttribute);
    }
}