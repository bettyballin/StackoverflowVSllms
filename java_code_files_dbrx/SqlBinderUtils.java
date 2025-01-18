import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SqlBinderUtils {
    public static String getBindingSql(PreparedStatement preparedStatement, List<String> listOfValues) throws SQLException {
        StringBuilder sql = new StringBuilder(preparedStatement.toString());
        for (int i = 0; i < listOfValues.size(); ++i) {
            // Add a ? placeholder for each value in the list and add the corresponding condition to the "conditions" list
            sql.deleteCharAt(sql.lastIndexOf("?"));
            sql.append("\"").append(listOfValues.get(i)).append("\",");
        }
        // Remove the final comma, close the parenthesis and add an ORDER BY clause if needed after the WHERE statement
        sql.deleteCharAt(sql.length() - 1);
        return sql.toString();
    }
    public static void main(String[] args) {
    }
}