import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdater_1 {

    private static final Object lock = new Object();
    private static final String DB_URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public void performInsert(List<Data> dataList) {
        // Synchronize on a shared object to prevent concurrent access issues
        synchronized (lock) {
            for (Data data : dataList) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO table_name (column1, column2) VALUES (?, ?)")) {

                    pstmt.setString(1, data.getColumn1());
                    pstmt.setString(2, data.getColumn2());
                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    // Handle specific exceptions here
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        DatabaseUpdater_1 updater = new DatabaseUpdater_1();
        List<Data> dataList = new ArrayList<>();
        // Initialize your data list
        // For example:
        dataList.add(new Data("value1", "value2"));
        dataList.add(new Data("value3", "value4"));

        updater.performInsert(dataList);
    }
}

class Data {
    private String column1;
    private String column2;

    public Data(String column1, String column2) {
        this.column1 = column1;
        this.column2 = column2;
    }

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }
}