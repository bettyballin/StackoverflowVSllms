import java.sql.*;
import java.util.Properties;
import oracle.jdbc.driver.OracleDriver; // You may need this package if not installed yet.

public class Test_4 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        // Oracle JDBC Driver
        OracleDriver oracleDriver = new OracleDriver();
        Connection conn = null;
        try {
            conn = oracleDriver.connect(url, new Properties());
            if (conn != null) {
                DatabaseMetaData dmd = conn.getMetaData();
                ResultSet rs = dmd.getImportedKeys(null, "DB_SCHEMA", "ARTIST"); // replace with your schema name
                while (rs.next()){
                    System.out.println(
                        rs.getString("PKTABLE_NAME") + ": " +
                        rs.getString("FKCOLUMN_NAME"));
                }
            } else {
                throw new Exception("Failed to connect!");
            }
        } catch (Exception e) {
            // print or log the error message..
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex2){
                    throw new Exception("Failed to close connection!");
                }
            }
        }
    }
}