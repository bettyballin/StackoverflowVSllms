/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

public class DatabaseKeyDeleter {
    public static void main(String[] stringArray) {
        DatabaseKeyDeleter databaseKeyDeleter = new DatabaseKeyDeleter();
        databaseKeyDeleter.deleteKeys();
    }

    public void deleteKeys() {
        long[] lArray = new long[]{0L, 1L, 2L, 3L};
        String string = String.join((CharSequence)",", Collections.nCopies(lArray.length, "?"));
        String string2 = "DELETE FROM MyTable WHERE myPrimaryKey IN (" + string + ")";
        try (Connection connection = this.getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement(string2);
            for (int i = 0; i < lArray.length; ++i) {
                preparedStatement.setLong(i + 1, lArray[i]);
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.err.println("Error deleting keys: " + sQLException.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        throw new SQLException("Not implemented");
    }
}
