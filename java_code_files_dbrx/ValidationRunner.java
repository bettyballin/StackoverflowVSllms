public class ValidationRunner {

    private String[] tableNames = new String[] {"table1", "table2"};

    public void RunValidations(){
        try {
            ValidateAllTables(tableNames);
        } catch (Exception e) { // Logs all errors during the validation process.
            Log.Error("Failed to complete table validations", e);
        }
    }

    private void ValidateAllTables(String[] tableNames) {
        // Implementation
    }

    public static void main(String[] args) {
        new ValidationRunner().RunValidations();
    }
}

class Log {
    public static void Error(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }
}