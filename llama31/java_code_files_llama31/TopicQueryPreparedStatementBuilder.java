/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicQueryPreparedStatementBuilder {
    public static void main(String[] stringArray) {
        Connection connection = TopicQueryPreparedStatementBuilder.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bb_topics WHERE topic_poster = ? AND topic_id IN (  (SELECT MAX(topic_id) FROM bb_topics WHERE topic_poster = ? AND topic_id < ?),  (SELECT MIN(topic_id) FROM bb_topics WHERE topic_poster = ? AND topic_id > ?))");
            preparedStatement.setInt(1, 5);
            preparedStatement.setInt(2, 5);
            preparedStatement.setInt(3, 123);
            preparedStatement.setInt(4, 5);
            preparedStatement.setInt(5, 123);
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred while preparing the statement: " + sQLException.getMessage());
        }
    }

    private static Connection getConnection() {
        return null;
    }
}
