import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetRowCounter {
    public static int countRows(ResultSet resultSet) throws SQLException {
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount++;
        }
        return rowCount;
    }

    public static void main(String[] args) {
        // Example usage:
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM table");
        // int rowCount = countRows(resultSet);
        // System.out.println("Row count: " + rowCount);
    }
}