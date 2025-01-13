import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HolidayDAO {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Assuming you are using Oracle database, replace with your actual database URL and credentials
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO HOLIDAY (HOLIDAY_TYPE_CODE, CALENDAR_NAME, HOLIDAY_DATE, DESCRIPTION, CREATE_TS, UPDATE_TS) VALUES (?, ?, ?, ?, SYSDATE, SYSDATE)");
            pstmt.setInt(1, 2);
            pstmt.setString(2, "CZK");
            pstmt.setDate(3, java.sql.Date.valueOf("2009-11-17"));
            pstmt.setString(4, null);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}