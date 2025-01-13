import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseUtil_1_1 {
    public static void main(String[] args) {
        // You need to create a ResultSet instance and assign it to the 'resultset' variable.
        // Here, for demonstration purposes, we assume that 'resultset' is a valid ResultSet instance.
        ResultSet resultset = null; // You need to initialize this variable with a valid ResultSet instance.

        try {
            ResultSetMetaData metaData = resultset.getMetaData();
            int columnIndex = metaData.getColumnIndex("add_date");
            String addDateStr = resultset.getString(columnIndex);
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}