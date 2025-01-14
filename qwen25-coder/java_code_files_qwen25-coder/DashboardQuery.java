import java.sql.*;

public class DashboardQuery {
    String sql = "/* SELECT for Dashboard Widget */ SELECT * FROM my_table";
    Connection connection = null;
    PreparedStatement stmt;

    {
        try {
            stmt = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}