/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSearcher {
    public static void main(String[] stringArray) {
        String string = "jdbc:your_database_url";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            String[] stringArray2 = new String[]{"search_string_1", "search_string_2"};
            for (int i = 0; i < stringArray2.length; ++i) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM table WHERE field1 LIKE ? OR field2 LIKE ? OR field3 LIKE ?");
                preparedStatement.setString(1, "%" + stringArray2[i] + "%");
                preparedStatement.setString(2, "%" + stringArray2[i] + "%");
                preparedStatement.setString(3, "%" + stringArray2[i] + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery();){
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                    }
                    continue;
                }
            }
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
