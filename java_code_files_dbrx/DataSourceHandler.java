public class DataSourceHandler {

    private DataSourceCredentialsPlugin credentials;

    public DataSourceHandler() {
        credentials = new DataSourceCredentialsPlugin();
    }

    // Add function that retrieves row count of your datasource table.
    private int GetRowCount() {
        // Implement code here to retrieve row counts
        int row_count = 0;
        // Code to retrieve row count (placeholder)
        return row_count;
    }

    public void processData() {
        for (int i = 1; i <= this.GetRowCount(); i++) {
            // Set the index property of your DataSourceCredentialsPlugin to current iteration value.
            // i.e., this.credentials.Index = i;
            this.credentials.Index = i;

            // Add other necessary code or make HTTP Request here which is specific to each row in data source.
        }
    }

    public static void main(String[] args) {
        DataSourceHandler handler = new DataSourceHandler();
        handler.processData();
    }
}

class DataSourceCredentialsPlugin {
    public int Index;

    // Other properties and methods
}