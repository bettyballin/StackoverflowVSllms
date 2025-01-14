import java.util.List;
import java.util.ArrayList;

public class GoodStoreService {

    private Repository repository = new Repository();

    @Transactional
    public void storeCargo(Cargo cargo) {
        for (Good good : cargo.getGoods()) {
            validateBeforeStore(good);
            repository.save(good);
        }
    }

    private void validateBeforeStore(Good good) {
        // Additional validation logic before storing in the database
    }

    public static void main(String[] args) {
    }
}

// Dummy @Transactional annotation
@interface Transactional {
}

// Dummy Good class
class Good {
}

// Dummy Cargo class
class Cargo {
    public List<Good> getGoods() {
        // Return list of goods
        return new ArrayList<Good>();
    }
}

// Dummy Repository class
class Repository {
    public void save(Good good) {
        // Save good to database
    }
}