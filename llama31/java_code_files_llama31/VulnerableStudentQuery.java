/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VulnerableStudentQuery {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydb";
        String string2 = "myuser";
        String string3 = "mypassword";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE NAME = ?");
            preparedStatement.setString(1, "Robert'); DROP TABLE STUDENTS; --");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
