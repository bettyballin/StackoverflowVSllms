import java.sql.*;

// Import Oracle and MySQL drivers
import oracle.jdbc.OracleDriver;
import com.mysql.cj.jdbc.Driver;

public class OracleToMySQL {
    public static void main(String[] args) throws SQLException {
        // Oracle connection settings
        String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String oracleUser = "your_username";
        String oraclePassword = "your_password";

        // MySQL connection settings
        String mysqlUrl = "jdbc:mysql://localhost:3306/your_database";
        String mysqlUser = "your_username";
        String mysqlPassword = "your_password";

        // Load Oracle and MySQL drivers
        DriverManager.registerDriver(new OracleDriver());
        DriverManager.registerDriver(new Driver());

        // Connect to Oracle and MySQL
        Connection oracleConn = DriverManager.getConnection(oracleUrl, oracleUser, oraclePassword);
        Connection mysqlConn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);

        // Retrieve data from Oracle and insert into MySQL
        // Use prepared statements to improve performance and security
        PreparedStatement oracleStmt = oracleConn.prepareStatement("SELECT * FROM your_oracle_table");
        ResultSet oracleRs = oracleStmt.executeQuery();

        PreparedStatement mysqlStmt = mysqlConn.prepareStatement("INSERT INTO your_mysql_table VALUES (?, ?)");
        while (oracleRs.next()) {
            // Insert data into MySQL
            mysqlStmt.setString(1, oracleRs.getString("column1"));
            mysqlStmt.setString(2, oracleRs.getString("column2"));
            mysqlStmt.executeUpdate();
        }

        // Close connections and statements
        oracleRs.close();
        oracleStmt.close();
        oracleConn.close();
        mysqlStmt.close();
        mysqlConn.close();
    }
}