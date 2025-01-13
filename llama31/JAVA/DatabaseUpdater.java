import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class YourObject {
    private String uniqueColumn;
    private int counter;

    public String getUniqueColumn() {
        return uniqueColumn;
    }

    public void setUniqueColumn(String uniqueColumn) {
        this.uniqueColumn = uniqueColumn;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

public class DatabaseUpdater {
    public static void main(String[] args) {
        // Initialize connection and yourList
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String[] uniqueColumns = {"column1", "column2", "column3"};
        int[] counters = {1, 2, 3};

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseUpdater updater = new DatabaseUpdater();
            updater.updateDatabase(conn, uniqueColumns, counters);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateDatabase(Connection conn, String[] uniqueColumns, int[] counters) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO your_table (unique_column, counter) VALUES (?, ?) ON DUPLICATE KEY UPDATE counter = counter + VALUES(counter)")) {
            for (int i = 0; i < uniqueColumns.length; i++) {
                stmt.setString(1, uniqueColumns[i]);
                stmt.setInt(2, counters[i]);
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}