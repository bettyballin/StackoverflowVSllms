import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessor_5_5 {
    private Connection connection;

    public DatabaseAccessor_5(Connection connection) {
        this.connection = connection;
    }

    public String getCell(String sql, String[] parameters) {
        String out = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 1; i <= parameters.length; i++) {
                String parameter = parameters[i - 1];
                ps.setString(i, parameter);
            }
            rs = ps.executeQuery();
            if (rs.first()) {
                out = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        // You need to establish a database connection here and pass it to the DatabaseAccessor_5 constructor
        // For example:
        // Connection connection = DriverManager.getConnection("url", "user", "password");
        // DatabaseAccessor_5 accessor = new DatabaseAccessor_5(connection);
        // accessor.getCell("sql", new String[]{"param1", "param2"});
    }
}