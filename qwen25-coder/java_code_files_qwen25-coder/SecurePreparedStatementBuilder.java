import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurePreparedStatementBuilder {

    public static void main(String[] args) throws SQLException {

        Connection connection = null; // Initialize your connection appropriately
        String sortOrder = "ASC"; // assuming sortOrder is safe input
        int offset = 0;

        String sql = "select * from Customer_Table ORDER BY ? LIMIT 100 OFFSET ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, sortOrder); // assuming sortOrder is safe input

        preparedStatement.setInt(2, offset);

        ResultSet resultSet = preparedStatement.executeQuery();

    }
}