/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HolidayDAO {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO HOLIDAY (HOLIDAY_TYPE_CODE, CALENDAR_NAME, HOLIDAY_DATE, DESCRIPTION, CREATE_TS, UPDATE_TS) VALUES (?, ?, ?, ?, SYSDATE, SYSDATE)");
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "CZK");
            preparedStatement.setDate(3, Date.valueOf("2009-11-17"));
            preparedStatement.setString(4, null);
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error occurred: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
