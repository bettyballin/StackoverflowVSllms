import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string value: ");
        String userInput = scanner.nextLine(); // get the string from user input

        System.out.print("Enter an integer id: ");
        int id = scanner.nextInt(); // get the id from user input

        // Example query - "very nice;) DROP TABLE FOO;" would be treated as a literal string
        String updateStatement = "UPDATE MyTable SET column1 = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(
                "<database_url>", "<username>", "<password>");
             PreparedStatement ps = connection.prepareStatement(updateStatement)) {
            // Set the user input values for each parameter in order of their appearance
            ps.setString(1, userInput);
            ps.setInt(2, id);

            int rowsUpdated = ps.executeUpdate();
            System.out.println(rowsUpdated + " rows updated.");
        } catch (SQLException se) {
            System.out.println("There was an error with the SQL query: " + se.getMessage());
        }
    }
}