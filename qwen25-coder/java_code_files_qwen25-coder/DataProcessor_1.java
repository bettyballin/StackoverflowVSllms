import java.sql.*;

public class DataProcessor_1 {

    public void processLargeDataSet(String url, String sql) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                // Process the current row
                String data = resultSet.getString("column_name");
                // Example processing function
                processData(data);
            }
        } catch (SQLException e) {
            throw new SQLException("An error occurred while processing the data set", e);
        }
    }

    private void processData(String data) {
        // Implement your data processing logic here
    }

    public static void main(String[] args) {
        DataProcessor_1 processor = new DataProcessor_1();
        String url = "jdbc:oracle:thin:@localhost:1521:mydb";
        String sql = "SELECT column_name FROM large_table";

        try {
            processor.processLargeDataSet(url, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}