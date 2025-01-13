/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException sQLException) {
            throw new RuntimeException(sQLException);
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException sQLException) {
                throw new RuntimeException(sQLException);
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException sQLException) {
                throw new RuntimeException(sQLException);
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            }
            catch (SQLException sQLException) {
                throw new RuntimeException(sQLException);
            }
        }
    }

    public static void executeQuery(String string, Object ... objectArray) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(string);
            for (int i = 0; i < objectArray.length; ++i) {
                preparedStatement.setObject(i + 1, objectArray[i]);
            }
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            try {
                throw new RuntimeException(sQLException);
            }
            catch (Throwable throwable) {
                DBUtils.closeStatement(preparedStatement);
                DBUtils.closeConnection(connection);
                throw throwable;
            }
        }
        DBUtils.closeStatement(preparedStatement);
        DBUtils.closeConnection(connection);
    }

    public static ResultSet executeQueryWithResult(String string, Object ... objectArray) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(string);
            for (int i = 0; i < objectArray.length; ++i) {
                preparedStatement.setObject(i + 1, objectArray[i]);
            }
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException sQLException) {
            throw new RuntimeException(sQLException);
        }
        return resultSet;
    }

    public static void main(String[] stringArray) {
        DBUtils.executeQuery("INSERT INTO my_table (name, age) VALUES (?, ?)", "John", 30);
        DBUtils.executeQuery("UPDATE my_table SET age = ? WHERE name = ?", 31, "John");
        DBUtils.executeQuery("DELETE FROM my_table WHERE name = ?", "John");
        ResultSet resultSet = DBUtils.executeQueryWithResult("SELECT * FROM my_table WHERE age > ?", 25);
        try {
            while (resultSet.next()) {
                String string = resultSet.getString("name");
                int n = resultSet.getInt("age");
                System.out.println(string + " is " + n + " years old.");
            }
        }
        catch (SQLException sQLException) {
            throw new RuntimeException(sQLException);
        }
        finally {
            DBUtils.closeResultSet(resultSet);
        }
    }
}
