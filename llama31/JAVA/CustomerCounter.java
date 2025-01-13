import java.lang.String;
import java.sql.*;

public class CustomerCounter {
    public static int countCustomers(Connection conn, String state, int movieID) throws SQLException {
        String query = "SELECT COUNT(*) as numCustomers FROM CUSTOMER C JOIN RENTS R ON C.ID = R.cid WHERE C.ST = ? AND R.mid = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, state);
            pstmt.setInt(2, movieID);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("numCustomers");
                }
            }
        }
        
        return 0; // No rows found
    }

	public static void main(String[] args) {
	}
}