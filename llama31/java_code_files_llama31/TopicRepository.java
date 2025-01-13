/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRepository {
    private Connection con;
    private int topicId;
    private Result specificTopic;

    public Result getSpecificTopic() {
        String string = "Select msg_body, msg_author from lawers_topic_msg where msg_id = ?";
        try {
            this.con = Mysql.getConnection();
            PreparedStatement preparedStatement = this.con.prepareStatement(string);
            preparedStatement.setInt(1, this.topicId);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.specificTopic = ResultSupport.toResult(resultSet);
            this.con.close();
            preparedStatement.close();
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
        return this.specificTopic;
    }

    public static void main(String[] stringArray) {
        TopicRepository topicRepository = new TopicRepository();
        topicRepository.topicId = 1;
        Result result = topicRepository.getSpecificTopic();
        System.out.println(result);
    }
}
