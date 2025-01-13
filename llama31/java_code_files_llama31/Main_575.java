/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_575 {
    public static void main(String[] stringArray) {
        String string2 = "jdbc:mysql://localhost:3306/your_database";
        String string3 = "your_username";
        String string4 = "your_password";
        try (Connection connection = DriverManager.getConnection(string2, string3, string4);){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT word, synonym FROM table ORDER BY word");
            preparedStatement.setFetchSize(1000);
            ResultSet resultSet = preparedStatement.executeQuery();
            HashMap<String, List> hashMap = new HashMap<String, List>();
            while (resultSet.next()) {
                String string5 = resultSet.getString(1);
                String object = resultSet.getString(2);
                hashMap.computeIfAbsent(string5, string -> new ArrayList()).add(object);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                System.out.println((String)entry.getKey() + ": " + String.valueOf(entry.getValue()));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
