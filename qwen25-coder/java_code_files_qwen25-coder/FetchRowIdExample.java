import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OraclePreparedStatement;

public class FetchRowIdExample {
    public static void main(String[] args) {
        try {
            // Create the data source
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@server:1521:sid");
            ods.setUser("app_user");
            ods.setPassword("pass");

            // Get a connection
            try (Connection conn = ods.getConnection()) {
                // Prepare the statement
                String sql = "INSERT INTO tableA (some_id) VALUES (?) RETURNING ROWID INTO ?";
                PreparedStatement st = conn.prepareStatement(sql);

                // Cast to OraclePreparedStatement to use Oracle-specific methods
                OraclePreparedStatement ops = (OraclePreparedStatement) st;

                // Set the value of the column being inserted
                ops.setInt(1, 1);

                // Register the output parameter for the ROWID
                ops.registerReturnParameter(2, java.sql.Types.VARCHAR);

                // Execute the statement
                ops.executeUpdate();

                // Retrieve the ROWID from the return result set
                ResultSet rs = ops.getReturnResultSet();
                if (rs.next()) {
                    String rowId = rs.getString(1);
                    System.out.println("Inserted Row ID: " + rowId);
                }

                // Close the statement
                st.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}