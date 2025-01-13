/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogPostRetriever {
    public static void main(String[] stringArray) {
        String string = "SELECT bp.*, COUNT(r.id) AS reply_count FROM blog_posts bp LEFT JOIN replies r ON bp.id = r.blog_post_id GROUP BY bp.id ORDER BY reply_count DESC LIMIT 30 OFFSET ?";
        try (Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");){
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            int n = 0;
            preparedStatement.setInt(1, n);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
