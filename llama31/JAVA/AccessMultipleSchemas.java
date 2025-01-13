import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessMultipleSchemas {
    public static void main(String[] args) throws Exception {
        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String username = "your_username";
        String password = "your_password";

        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        conn.setSchema("SCOTT");

        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEES");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }

        pstmt.close();
        rs.close();
        conn.close();
    }
}