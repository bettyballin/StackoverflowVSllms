import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAO_12_12 {
    public static void main(String[] args) {
        // Insecure raw SQL query
        String username = "exampleUsername";
        String password = "examplePassword";
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Insecure raw SQL query: " + query);

        // Secure ORM query with Hibernate
        // Note: You need to have Hibernate set up and a session created for this to work
        Session session = null; // Initialize your Hibernate session here
        Query hibernateQuery = session.createQuery("FROM User WHERE username = :username AND password = :password");
        hibernateQuery.setParameter("username", username);
        hibernateQuery.setParameter("password", password);
        System.out.println("Secure ORM query with Hibernate: " + hibernateQuery.getQueryString());
    }
}