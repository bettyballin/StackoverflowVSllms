import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchInsertSqlExecutor {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String user = "username";
        String password = "password";
        List<YourData> dataList = new ArrayList<>();

        // Add sample data to dataList
        dataList.add(new YourData());
        dataList.add(new YourData());

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (YourData data : dataList) {
                    pstmt.setString(1, data.getColumn1());
                    pstmt.setString(2, data.getColumn2());
                    pstmt.addBatch();
                }
                int[] updateCounts = pstmt.executeBatch();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class YourData {
    public String getColumn1() {
        return "value1";
    }

    public String getColumn2() {
        return "value2";
    }
}