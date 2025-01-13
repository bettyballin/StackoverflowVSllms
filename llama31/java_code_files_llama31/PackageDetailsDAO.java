/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDetailsDAO {
    public static void main(String[] stringArray) {
        String string = "SELECT pd.id, s1.state_name AS sender_state, s2.state_name AS receiver_state FROM Package_Details pd JOIN States s1 ON pd.sender_state = s1.state_id JOIN States s2 ON pd.receiver_state = s2.state_id";
        try (Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");){
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + ", " + resultSet.getString("sender_state") + ", " + resultSet.getString("receiver_state"));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
