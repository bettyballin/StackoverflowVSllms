interface JdbcMigration {
    void migrate(Context context) throws Exception;
}

class Context {
    // Add any necessary methods or fields here.
}

public class V3__AddNewColumn implements JdbcMigration {
    public void migrate(Context context) throws Exception {
        // Run your database changes here.
    }
}