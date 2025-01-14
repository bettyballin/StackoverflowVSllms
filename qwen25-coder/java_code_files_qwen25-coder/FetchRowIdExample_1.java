import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OraclePreparedStatement;

public class FetchRowIdExample_1 {
    public static void main(String[] args) {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@server:1521:sid");
            ods.setUser("app_user");
            ods.setPassword("pass");

            try (Connection conn = ods.getConnection();
                 PreparedStatement st = conn.prepareStatement(
                     "INSERT INTO tableA (some_id) VALUES (?) RETURNING ROWID INTO ?")) {

                // Set the value of the column being inserted
                st.setInt(1, 1);

                // Cast to OraclePreparedStatement to use Oracle-specific methods
                OraclePreparedStatement ops = (OraclePreparedStatement) st;

                // Register the ROWID parameter as an output variable
                ops.registerReturnParameter(2, java.sql.Types.VARCHAR);

                st.executeUpdate();

                // Retrieve the ROWID from the returned ResultSet
                try (ResultSet rs = ops.getReturnResultSet()) {
                    if (rs.next()) {
                        String rowId = rs.getString(1);
                        System.out.println("Inserted Row ID: " + rowId);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}