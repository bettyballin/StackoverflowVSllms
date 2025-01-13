import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRepository {
    private Connection con;
    private int topicId;
    private Result specificTopic;

    public Result getSpecificTopic() {
        String query = "Select msg_body, msg_author from lawers_topic_msg where msg_id = ?";

        try {
            con = Mysql.getConnection(); // Assuming Mysql is a class with a static method getConnection()
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, topicId);
            ResultSet rs = stmt.executeQuery();
            specificTopic = ResultSupport.toResult(rs);

            con.close();
            stmt.close();
        } catch (SQLException e) {
            // Don't swallow exceptions! At least log them or rethrow.
            System.err.println("Error: " + e.getMessage());
        }
        return this.specificTopic;
    }

    public static void main(String[] args) {
        // Create an instance of TopicRepository and call getSpecificTopic()
        TopicRepository topicRepository = new TopicRepository();
        topicRepository.topicId = 1; // Set the topicId
        Result result = topicRepository.getSpecificTopic();
        System.out.println(result);
    }
}

// Assuming Result and ResultSupport are custom classes
class Result {
    // Implement the Result class
}

class ResultSupport {
    public static Result toResult(ResultSet rs) {
        // Implement the toResult method
        return null;
    }
}

// Assuming Mysql is a class with a static method getConnection()
class Mysql {
    public static Connection getConnection() {
        // Implement the getConnection method
        return null;
    }
}