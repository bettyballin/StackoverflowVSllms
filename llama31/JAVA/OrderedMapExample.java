import java.util.LinkedHashMap;
import java.util.Map;

// Define the Image class
class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class OrderedMapExample {
    public static void main(String[] args) {
        Map<String, Image> myMap = new LinkedHashMap<>();

        // Add entries to the map
        myMap.put("id1", new Image("image1"));
        myMap.put("id2", new Image("image2"));
        myMap.put("id3", new Image("image3"));

        // Iterate over the entries in the order they were inserted
        for (Map.Entry<String, Image> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}