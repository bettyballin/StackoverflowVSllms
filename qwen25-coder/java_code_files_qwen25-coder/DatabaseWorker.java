import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWorker implements Runnable {
    private final String query = "SELECT * FROM users WHERE age > ?";

    @Override
    public void run() {
        try (Connection connection = DriverManager.getConnection("jdbc:yourdb", "user", "password");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, 25);
            // Execute your query here

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DatabaseWorker());
        Thread thread2 = new Thread(new DatabaseWorker());

        thread1.start();
        thread2.start();
    }
}