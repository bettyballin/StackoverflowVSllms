import java.lang.String;

// Your Updater class with the updateRow method
class Updater {
    private DatabaseHelper databaseHelper;

    public Updater(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void updateRow(int id, String columnName, Object value) {
        // Collect parameters and pass to the helper routine
        databaseHelper.invokeStoredProcedure(id, columnName, value);
    }
}

// Helper class responsible for invoking stored procedure
public class DatabaseHelper {
    public void invokeStoredProcedure(int id, String columnName, Object value) {
        // Actual code to call the stored procedure goes here
    }

    public static void main(String[] args) {
        // Optional: Add code here to test the Updater and DatabaseHelper classes
    }
}