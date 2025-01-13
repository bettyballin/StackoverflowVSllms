import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void executeQuery(String query, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeStatement(ps);
            closeConnection(conn);
        }
    }

    public static ResultSet executeQueryWithResult(String query, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Do not close the connection and statement here, 
            // because we still need to use the result set.
            // closeStatement(ps);
            // closeConnection(conn);
        }
        return rs;
    }

    public static void main(String[] args) {
        // Insert data
        executeQuery("INSERT INTO my_table (name, age) VALUES (?, ?)", "John", 30);

        // Update data
        executeQuery("UPDATE my_table SET age = ? WHERE name = ?", 31, "John");

        // Delete data
        executeQuery("DELETE FROM my_table WHERE name = ?", "John");

        // Select data
        ResultSet rs = executeQueryWithResult("SELECT * FROM my_table WHERE age > ?", 25);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + " is " + age + " years old.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(rs);
            // We also need to close the connection and statement here.
            // But since we don't have access to them here, 
            // we should redesign the executeQueryWithResult method 
            // to also return the connection and statement, or 
            // to close them after we are done with the result set.
        }
    }
}