import java.sql.*;
import java.util.*;

public class OracleAccess {
    static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

    public ArrayList<String> getOracleData(String params) throws SQLException, ClassNotFoundException {
        // Register JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        ArrayList<String> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, "username", "password")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from table where conditions=" + params); // replace with appropriate query and parameters
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfReturnFields = rsmd.getColumnCount();

            while (rs.next()) {
                StringBuilder resultString = new StringBuilder();
                for (int i = 1; i <= numberOfReturnFields; i++) {
                    resultString.append(rs.getString(i));
                    if (i != numberOfReturnFields) {
                        resultString.append(", ");
                    }
                }
                result.add(resultString.toString());
            }
            return result; // return your processed data here
        } catch (Exception e) {
            System.out.println("SQLException caught: " + e.getMessage());
            throw new RuntimeException(); // or do some other exception handling
        } finally {
            // Any necessary cleanup can be done here
        }
    }
}