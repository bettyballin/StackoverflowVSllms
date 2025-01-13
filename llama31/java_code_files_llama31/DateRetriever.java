/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DateRetriever {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myuser";
        String string3 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT date FROM mytable");
            while (resultSet.next()) {
                Date date = resultSet.getDate("date");
                LocalDate localDate = date.toLocalDate();
                System.out.println(localDate);
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
