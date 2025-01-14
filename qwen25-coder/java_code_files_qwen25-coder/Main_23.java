import java.lang.String;
// Database class representing the database connection
class Database {
    // Methods to interact with the database
}

// Model class that uses the Database object
class MyModel {
    private final Database db;

    // Constructor injection of Database dependency
    public MyModel(Database db) {
        this.db = db;
    }

    // Method in model that requires DB access
    public void fetchData() {
        // Use 'db' to interact with database
    }
}

// Example usage
public class Main_23 {
    public static void main(String[] args) {
        Database db = new Database();  // Initialize database connection
        MyModel model = new MyModel(db); // Pass the DB object to the model

        model.fetchData();
    }
}