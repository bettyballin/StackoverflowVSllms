import java.sql.Connection;
import java.sql.PreparedStatement;

public class Example_22 {
    public void executeQuery(Connection conn) throws Exception {
        String sql = "SELECT * FROM your_table WHERE PRT_STATUS=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Use OracleTypes.FIXED_CHAR to ensure proper comparison with CHAR columns
            pstmt.setObject(1, "ONT", OracleTypes.FIXED_CHAR);
            
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Process result set
                }
            }
        }
    }

    public static void main(String[] args) {
    }

    // Stub class to mimic OracleTypes
    public static class OracleTypes {
        public static final int FIXED_CHAR = 999;
    }
}