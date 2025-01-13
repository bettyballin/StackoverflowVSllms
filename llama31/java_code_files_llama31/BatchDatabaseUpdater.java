/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchDatabaseUpdater {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Object object2;
            String string = "INSERT INTO my_table (id, name, value) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(string);
            for (Object object2 : arrayList) {
                preparedStatement.setInt(1, ((Entity)object2).getId());
                preparedStatement.setString(2, ((Entity)object2).getName());
                preparedStatement.setString(3, ((Entity)object2).getValue());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            String string2 = "UPDATE my_table SET name = ?, value = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(string2);
            for (Object object3 : arrayList2) {
                preparedStatement.setString(1, ((Entity)object3).getName());
                preparedStatement.setString(2, ((Entity)object3).getValue());
                preparedStatement.setInt(3, ((Entity)object3).getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            object2 = "DELETE FROM my_table WHERE id = ?";
            preparedStatement = connection.prepareStatement((String)object2);
            for (Entity entity : arrayList3) {
                preparedStatement.setInt(1, entity.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        }
        catch (SQLException sQLException) {
            System.out.println("SQL exception: " + sQLException.getMessage());
        }
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println("SQL exception: " + sQLException.getMessage());
            }
        }
    }
}
