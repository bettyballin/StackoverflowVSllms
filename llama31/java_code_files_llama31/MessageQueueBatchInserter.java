/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MessageQueueBatchInserter {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO msg_queue (user_id, message) VALUES (?, ?)");
            connection.setAutoCommit(false);
            int n = 100;
            int n2 = 0;
            List list = null;
            String string = null;
            for (User user : list) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, string);
                preparedStatement.addBatch();
                if (++n2 % n != 0) continue;
                preparedStatement.executeBatch();
                connection.commit();
                preparedStatement.clearBatch();
            }
            if (n2 % n != 0) {
                preparedStatement.executeBatch();
                connection.commit();
            }
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Exception: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("SQL Exception while closing connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
