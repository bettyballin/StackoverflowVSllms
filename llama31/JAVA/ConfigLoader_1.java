import java.util.Properties;
import java.util.HashMap;

public class ConfigLoader_1_1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        // Assuming you have a properties file or some way to load properties
        // For demonstration purposes, we'll just set the property here
        props.setProperty("item_id", "some_item_id");

        String item_id = props.getProperty("item_id");
        HashMap<String, String> vars = new HashMap<>();
        vars.put("item_id", item_id);
    }
}