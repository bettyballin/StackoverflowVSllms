import java.sql.ResultSet;
import java.sql.SQLException;

// Assuming Query class is defined elsewhere, 
// for simplicity it's implemented here with only necessary methods.
class Query {
    private String query;

    public Query(String query) {
        this.query = query;
    }

    public ResultSet execute(int userId) throws SQLException {
        // This method should connect to the database and execute the query.
        // For brevity, it's not implemented here.
        return null;
    }
}

class User {
    private int id;
    private String username;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

public class UserDAO_11_11 {
    public User getUser(int userId) {
        // Construct the query
        Query query = new Query("SELECT u.*, ut.*, i.*, it.* FROM user u " +
                "INNER JOIN type ut ON ut.typeid = u.usertypeid " +
                "INNER JOIN image i ON i.imageid = u.imageid " +
                "INNER JOIN type it ON it.typeid = i.imagetypeid " +
                "WHERE u.userid = :userId");

        try {
            // Execute the query and retrieve the results
            ResultSet results = query.execute(userId);

            // Map the results to a User object
            User user = new User();
            if (results.next()) {
                user.setId(results.getInt("userid"));
                user.setUsername(results.getString("username"));
                // ...
            }

            return user;
        } catch (SQLException e) {
            // Handle SQL exception
            return null;
        }
    }

    public static void main(String[] args) {
        UserDAO_11 userDAO = new UserDAO_11();
        User user = userDAO.getUser(1);
    }
}