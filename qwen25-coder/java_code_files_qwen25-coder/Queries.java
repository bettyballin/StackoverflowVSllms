import java.lang.String;
// Example in Java using string constants
public class Queries {
    public static final String SELECT_USER_QUERY = 
        "SELECT user_id, username, email " +
        "FROM users " +
        "WHERE active = true";

    // Add more queries as needed

    // Usage
    public static void main(String[] args) {
        String query = Queries.SELECT_USER_QUERY;
        // Use the query as needed
    }
}