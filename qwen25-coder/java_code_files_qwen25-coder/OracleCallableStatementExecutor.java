import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class OracleCallableStatementExecutor {
    public static void main(String[] args) {
        Connection connection = null; // Obtain a database connection here

        try (CallableStatement cs = connection.prepareCall("{call S_S_TEST(?)}")) {
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    // Process each row
                }
            }  // ResultSet is auto-closed here due to try-with-resources
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}