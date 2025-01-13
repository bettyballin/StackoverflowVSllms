import java.lang.String;
public class QueryCreator_1 {
    public static String createQuery(String tableName, String columnName) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(tableName).append(" WHERE ").append(columnName).append(" = ?");
        return sb.toString();
    }

    public static void main(String[] args) {
        String tableName = "users";
        String columnName = "username";
        String query = createQuery(tableName, columnName);
        // ...
    }
}