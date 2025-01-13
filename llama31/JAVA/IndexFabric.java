import java.util.List;
import java.util.ArrayList;

// Define the PatriciaTrie class, as it was missing in the original code
class PatriciaTrie {
    public void insert(String key, Object value) {
        // Implement the insert logic for PatriciaTrie
        System.out.println("Inserting key: " + key + ", value: " + value);
    }
}

public class IndexFabric {
    private List<PatriciaTrie> layers;

    public IndexFabric(int numLayers) {
        this.layers = new ArrayList<>();
        for (int i = 0; i < numLayers; i++) {
            layers.add(new PatriciaTrie());
        }
    }

    public void insert(String key, Object value) {
        for (int i = 0; i < layers.size(); i++) {
            // calculate the prefix length for this layer
            int prefixLength = (i + 1) * 5; // e.g., 5, 10, 15, etc.
            String prefix = key.substring(0, Math.min(prefixLength, key.length()));
            layers.get(i).insert(prefix, value);
        }
    }

    // other methods for search, delete, etc.

    public static void main(String[] args) {
        IndexFabric indexFabric = new IndexFabric(3);
        indexFabric.insert("hello world", "example value");
    }
}