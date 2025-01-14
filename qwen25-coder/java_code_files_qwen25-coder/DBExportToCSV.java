import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBExportToCSV {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/yourDatabase";
        String username = "username";
        String password = "password";
        String query = "SELECT * FROM yourTable";
        String csvFilePath = "output.csv";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             FileWriter fileWriter = new FileWriter(csvFilePath)) {

            int columnsCount = resultSet.getMetaData().getColumnCount();

            // Write headers
            for (int i = 1; i <= columnsCount - 1; i++) {
                fileWriter.append(resultSet.getMetaData().getColumnName(i)).append(",");
            }
            fileWriter.append(resultSet.getMetaData().getColumnName(columnsCount)).append("\n");

            // Write data
            while (resultSet.next()) {
                for (int i = 1; i <= columnsCount - 1; i++) {
                    fileWriter.append(resultSet.getString(i)).append(",");
                }
                fileWriter.append(resultSet.getString(columnsCount)).append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}