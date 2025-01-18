import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class SPCallerjava {
    public static void main(String[] args) {
        String callSP = "{call MyProcedure(?)}";
        try (Connection conn = DriverManager.getConnection("YOUR_CONNECTION_URL", "YOUR_USERNAME", "YOUR_PASSWORD");
             CallableStatement stmt = conn.prepareCall(callSP);) {
            // Bind the out parameter before calling the SP.
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();

            try (ResultSet rs = (ResultSet)stmt.getObject(1);) { // Cast Object to ResultSet
                while (rs.next()) {
                    System.out.println("column 1 from current row: " + rs.getString(1));
                    // and so on...
                }
            } catch (SQLException e) {
                System.err.print(e);
            }
        } catch (SQLException ex) {
            System.out.println("Error calling stored procedure!!");
            ex.printStackTrace();
        }
    }
}