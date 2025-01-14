import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DashboardWidgetQueryExecutor {

    private static Logger logger = Logger.getLogger(DashboardWidgetQueryExecutor.class.getName());
    private Connection connection;

    {
        // Instance initialization block
        logger.info("Executing query for Dashboard Widget: SELECT * FROM my_table");
        String sql = "SELECT * FROM my_table";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Do something with the statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}