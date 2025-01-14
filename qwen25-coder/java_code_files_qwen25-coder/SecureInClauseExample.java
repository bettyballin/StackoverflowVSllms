import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureInClauseExample {
    public static void main(String[] args) {
        Connection connection = null; // Initialize your database connection here

        try {
            List<String> values = List.of("A", "B", "C"); // Your list of values
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT my_column FROM my_table where search_column IN (");

            for (int i = 0; i < values.size(); i++) {
                if (i > 0) {
                    queryBuilder.append(", ");
                }
                queryBuilder.append("?");
            }
            queryBuilder.append(")");

            String query = queryBuilder.toString();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setString(i + 1, values.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Process the result set
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}