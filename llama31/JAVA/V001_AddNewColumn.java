import java.lang.String;

// Create a migration that adds a new column to a table
class BaseJavaMigration {
    public void migrate(Context context) {}
}

class Context {
    public Statement getStatement() {
        return new Statement();
    }
}

class Statement {
    public void execute(String query) {
        System.out.println("Executing query: " + query);
    }
}

public class V001_AddNewColumn extends BaseJavaMigration {
    @Override
    public void migrate(Context context) {
        // Add new column to table
        context.getStatement().execute("ALTER TABLE mytable ADD COLUMN newcolumn VARCHAR(255)");
    }

    public static void main(String[] args) {
        V001_AddNewColumn migration = new V001_AddNewColumn();
        migration.migrate(new Context());
    }
}

// Create a migration that normalizes a table
class V002_NormalizeTable extends BaseJavaMigration {
    @Override
    public void migrate(Context context) {
        // Normalize table
        context.getStatement().execute("CREATE TABLE normalized_table (id INT PRIMARY KEY, name VARCHAR(255))");
        context.getStatement().execute("INSERT INTO normalized_table SELECT id, name FROM mytable");
        context.getStatement().execute("DROP TABLE mytable");
    }

    public static void main(String[] args) {
        V002_NormalizeTable migration = new V002_NormalizeTable();
        migration.migrate(new Context());
    }
}