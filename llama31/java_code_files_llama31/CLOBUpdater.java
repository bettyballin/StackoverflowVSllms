/*
 * Decompiled with CFR 0.152.
 */
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CLOBUpdater {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
            int n = 1;
            String string = "This is the content to append.\n";
            String string2 = CLOBUpdater.fetchExistingCLOBContent(connection, n);
            String string3 = string2 + string + "\n";
            CLOBUpdater.updateCLOBContent(connection, n, string3);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String fetchExistingCLOBContent(Connection connection, int n) throws SQLException {
        String string = "SELECT log FROM table WHERE id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(string);
            preparedStatement.setInt(1, n);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String string2 = resultSet.getString(1);
                return string2;
            }
            String string3 = "";
            return string3;
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void updateCLOBContent(Connection connection, int n, String string) throws SQLException {
        String string2 = "UPDATE table SET log = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(string2);
            preparedStatement.setCharacterStream(1, (Reader)new StringReader(string), string.length());
            preparedStatement.setInt(2, n);
            preparedStatement.executeUpdate();
        }
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
    }
}
