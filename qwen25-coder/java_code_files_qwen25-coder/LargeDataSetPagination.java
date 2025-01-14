import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LargeDataSetPagination {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:yourDB";
        String user = "yourUsername";
        String password = "yourPassword";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Prepare SQL query
            String sql = "SELECT * FROM your_table_name";
            try (PreparedStatement pstmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {

                // Set the fetch size to an appropriate number for efficiency
                pstmt.setFetchSize(20);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        // Process row data
                        System.out.println(rs.getString("column_name"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}