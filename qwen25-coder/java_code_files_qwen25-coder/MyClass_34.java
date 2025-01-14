import java.sql.*;

public class MyClass {

    private Connection conn; // Your database connection

    public ResultSet getSpool(int gSpoolKey) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{ ? = call end_spool(?) }")) {

            stmt.registerOutParameter(1, Types.REF_CURSOR);  // Register the output parameter
            stmt.setInt(2, gSpoolKey);

            stmt.execute();

            return (ResultSet) stmt.getObject(1);
        }
    }
}