import java.lang.String;
public class SqlQueryBuilder {
    public String buildSQL(String schema, String table) {
        // Validate and sanitize the schema and table names before including them in your query
        if (!isValidSchemaName(schema) || !isValidTableName(table)) {
            throw new IllegalArgumentException("Invalid schema or table name.");
        }
        return "SELECT * FROM " + schema + "." + table;
    }
    
    private boolean isValidSchemaName(String schemaName) {
        // Implement your validation logic here
        return true; // Simplified for demonstration purposes
    }
    
    private boolean isValidTableName(String tableName) {
        // Implement your validation logic here
        return true; // Simplified for demonstration purposes
    }
    public static void main(String[] args) {
    }
}