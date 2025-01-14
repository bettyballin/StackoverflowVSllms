import java.sql.*;

public class PreparedStatementExecutor {
	public static void main(String[] args) throws Exception {
		Connection connection = null; // Obtain a real connection in practice
		String userInput = "someUserInput"; // Example user input

		String sql = "SELECT * FROM users WHERE name = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, userInput);
		ResultSet rs = stmt.executeQuery();

		// Process the ResultSet (not implemented)
	}
}