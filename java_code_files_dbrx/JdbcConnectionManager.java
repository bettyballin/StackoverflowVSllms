import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcConnectionManager {

    private DataSource dataSource;

    public JdbcConnectionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        // Assuming dataSource is obtained from somewhere
        DataSource dataSource = null; // Replace with actual DataSource initialization
        JdbcConnectionManager manager = new JdbcConnectionManager(dataSource);

        try (Connection connection = manager.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE age > ?")) {
            // prepare and execute the query here
        } catch (SQLException e) {
            // handle exception here
        }
    }
}