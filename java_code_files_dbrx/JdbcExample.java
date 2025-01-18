import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin://localhost:your_port", "username", "password");
            conn.setAutoCommit(false); //begin transaction

            // execute your update statements
            // ...

            conn.commit(); // commit the transaction
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}