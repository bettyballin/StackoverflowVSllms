import org.hibernate.Session;
import org.hibernate.Filter;

public class Main {
    public static void main(String[] args) {
        Session session = getSession(); // Assume getSession() returns a valid Session object

        session.enableFilter("notDeleted").setParameter("deleted", false); // Only filter the bars where deleted is not set yet (false)
        // execute your queries here... etc
    }

    public static Session getSession() {
        // Implement this method to obtain a Hibernate Session
        return null; // Placeholder
    }
}