/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LabelRetriever {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT label FROM labels WHERE field_name = ?");
            preparedStatement.setString(1, "height");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String string4 = resultSet.getString(1);
                System.out.println(string4);
            }
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
