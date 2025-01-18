import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RatingProviderFactory {
    private static final Map<String, Supplier<? extends RatingProvider>> map = new HashMap<>();
    static {
        map.put("imdb", Imdb::new);
        map.put("meta_critic", MetaCritic::new);
    }

    public static RatingProvider getRatingSupplier(String ratingType) {
        Supplier<? extends RatingProvider> supplier = map.get(ratingType);

        if (supplier != null){
            return supplier.get();
        } else {
            throw new RuntimeException("Unknown Type: " + ratingType);
        }
    }

    public static void main(String[] args) {
        // You can test the functionality here if needed
    }
}

interface RatingProvider {
    // Define methods for RatingProvider if necessary
}

class Imdb implements RatingProvider {
    public Imdb() {
        // Constructor implementation
    }
    // Implement methods from RatingProvider if necessary
}

class MetaCritic implements RatingProvider {
    public MetaCritic() {
        // Constructor implementation
    }
    // Implement methods from RatingProvider if necessary
}