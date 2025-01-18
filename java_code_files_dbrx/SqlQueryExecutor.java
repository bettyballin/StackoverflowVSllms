import java.lang.String;
import java.sql.*;

public class SqlQueryExecutor {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        String lastName = "Smith";

        String sql = "select * from table1 where last_name like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + lastName); // % sign is included here
        ResultSet rs = ps.executeQuery();
    }
}