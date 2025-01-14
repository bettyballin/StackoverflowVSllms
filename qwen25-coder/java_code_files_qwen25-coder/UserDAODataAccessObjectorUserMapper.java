import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAODataAccessObjectorUserMapper {
    public static void insert(UserBean user) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionUtil.getConnection();
            String query = "INSERT INTO user (name, age, sex, city) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getSex());
            statement.setString(4, user.getCity()); // Adjust this if city is not a String
            statement.executeUpdate();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {}
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {}
        }
    }

    public static void main(String[] args) {
    }
}

class UserBean {
    public String getName() {
        return null;
    }

    public int getAge() {
        return 0;
    }

    public String getSex() {
        return null;
    }

    public String getCity() {
        return null;
    }
}

class connectionUtil {
    public static Connection getConnection() throws SQLException {
        return null; // Placeholder for actual connection
    }
}