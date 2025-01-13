import java.lang.String;
public class QueryCreator {
    public static String createQuery(String tableName, String columnName) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?", tableName, columnName);
        return query;
    }

    public static void main(String[] args) {
        String tableName = "users";
        String columnName = "username";
        String query = createQuery(tableName, columnName);
        // ...
    }
}