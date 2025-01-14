import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Example code to illustrate evaluating databases based on criteria

        List<Database> databases = new ArrayList<>();
        databases.add(new Database("PostgreSQL", true, true, false));
        databases.add(new Database("MySQL", true, false, true));

        for (Database db : databases) {
            if (db.supportsACID && db.cloudNative) {
                System.out.println(db.name + " meets ACID compliance and is cloud-native.");
            }
        }
    }
}

class Database {
    String name;
    boolean supportsACID;
    boolean openSource;
    boolean cloudNative;

    public Database(String name, boolean supportsACID, boolean openSource, boolean cloudNative) {
        this.name = name;
        this.supportsACID = supportsACID;
        this.openSource = openSource;
        this.cloudNative = cloudNative;
    }
}