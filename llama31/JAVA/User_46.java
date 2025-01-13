import java.lang.String;

// Business object
public class User_46 {
    private DataStorage storage;

    public User(DataStorage storage) {
        this.storage = storage;
    }

    public void save() {
        storage.save(this);
    }
}

// Data storage interface
interface DataStorage {
    void save(User user);
}

// Concrete data storage implementation
class DatabaseStorage implements DataStorage {
    @Override
    public void save(User user) {
        // Database-specific implementation
        System.out.println("User saved to database");
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        DataStorage storage = new DatabaseStorage();
        User user = new User(storage);
        user.save();
    }
}