import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PersonFinder {
    public static void main(String[] args) {
        String hql = "FROM Person p WHERE lower(p.city) LIKE :searchTerm";
        Session session = null; // Obtain session
        String userInput = ""; // Obtain user input

        Query<Person> query = session.createQuery(hql);
        query.setParameter("searchTerm", "%" + userInput.toLowerCase() + "%");
        List<Person> result = query.list();
    }
}