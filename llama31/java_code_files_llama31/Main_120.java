/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main_120 {
    public static void main(String[] stringArray) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpassword");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT date, associate_id, COUNT(*) as per_date FROM tracking GROUP BY date, associate_id ORDER BY date");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("date") + " " + resultSet.getInt("associate_id") + " " + resultSet.getInt("per_date"));
        }
        resultSet.close();
        preparedStatement.close();
        PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT DISTINCT associate_id FROM tracking");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        while (resultSet2.next()) {
            System.out.println(resultSet2.getInt("associate_id"));
        }
        resultSet2.close();
        preparedStatement2.close();
        connection.close();
    }
}
