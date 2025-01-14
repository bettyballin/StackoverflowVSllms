import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.TimeZone;
import oracle.sql.TIMESTAMPTZ;
import oracle.jdbc.OracleResultSet;

public class TimeZoneExtractor {
    public static void main(String[] args) throws Exception {
        // Assume conn is an active JDBC connection to your Oracle database
        Connection conn = null; // Initialize this with your connection logic

        String sql = "SELECT timestamp_with_timezone_column FROM your_table WHERE condition";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                TIMESTAMPTZ timestamptz = ((OracleResultSet) rs).getTIMESTAMPTZ("timestamp_with_timezone_column");
                TimeZone timeZone = timestamptz.getTimeZone(conn);
                ZoneId zoneId = timeZone.toZoneId();
                System.out.println("Timezone: " + zoneId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
}