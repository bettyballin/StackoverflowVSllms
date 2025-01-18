import java.sql.*;

public class OracleDBConnector {
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}