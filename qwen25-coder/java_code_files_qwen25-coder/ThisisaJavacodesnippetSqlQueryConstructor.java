import java.util.Properties;
public class ThisisaJavacodesnippetSqlQueryConstructor {
    // Assuming you are constructing your SQL in Java using a configuration property
    static Properties config;

    static {
        // Initialize the config properties in static block
        config = new Properties();
        config.setProperty("database.schema", "myschema"); // Set your schema name
    }

    static String schemaName = config.getProperty("database.schema"); // Retrieve the schema name from the config
    static String sqlQuery = "SELECT * FROM " + schemaName + ".your_table_name";

    public static void main(String[] args) {
        // Output the SQL query
        System.out.println(sqlQuery);
    }
}