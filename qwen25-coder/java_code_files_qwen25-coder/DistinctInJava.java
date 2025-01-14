import java.sql.*;
import java.util.*;

public class DistinctInJava {
    public static void main(String[] args) throws SQLException {
        Set<String> uniqueValues = new HashSet<>();
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "user", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT column1, column2 FROM your_table");

        while (rs.next()) {
            String value = rs.getString(1) + "|" + rs.getString(2);
            uniqueValues.add(value);
        }
        // unique values are now in the HashSet `uniqueValues`
    }
}