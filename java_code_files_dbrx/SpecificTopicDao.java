import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SpecificTopicDao {

    private Result specificTopic;
    private Connection con;
    private Logger logger;
    private MysqlHelper mysql;
    private PreparedStatement stmt;

    public SpecificTopicDao() {
        logger = Logger.getLogger(SpecificTopicDao.class.getName());
        mysql = new MysqlHelper();
    }

    public int getTopicId() {
        // Dummy implementation
        return 1;
    }

    public Result getSpecificTopic() {
        String query = "Select msg_body, msg_author from lawers_topic_msg where msg_id=?";
        try {
            con = mysql.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            //stmt.setInt(1, topicId); // <- This is not executed in your code due to the way the query is being called on executeQuery() below
            //stmt.executeUpdate(); // <-- Don't use this when fetching data for ResultSet
            stmt.setInt(1, getTopicId());  // Set up parameters here as well before executing statement.
            ResultSet rs = stmt.executeQuery(); // no need to pass query string again here.
            int rowCount = rs.getRow();
            specificTopic = ResultSupport.toResult(rs);
            con.close();
            stmt.close();
        } catch (Exception e) {
            // Always log exceptions or you'll never know what is being thrown:
            logger.severe("Error while fetching specific topic..." + e.getMessage());
        } finally {
            try {
                if(con != null) { con.close(); }
            } catch(SQLException sqle2) {
                sqle2.printStackTrace();
            }
            try {
                if (stmt != null) { stmt.close(); }
            } catch(SQLException se2) {
                se2.printStackTrace();
            }
        }
        return this.specificTopic;
    }

    public static void main(String[] args) {
    }
}

class MysqlHelper {
    public Connection getConnection() {
        // Return a dummy connection
        return null;
    }
}

class Result {
    // Dummy class
}

class ResultSupport {
    public static Result toResult(ResultSet rs) {
        return new Result();
    }
}