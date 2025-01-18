import java.util.List;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class PersonFinderByCityNameStartsWith {
    public static void main(String[] args) {
        String userInput = "fran";
        Session session = null; // Obtain session from Hibernate session factory
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(Restrictions.ilike("city", "%" + userInput + "%"));
        List<Person> result = criteria.list();

        for (Person person : result) {
            // Process the persons found
        }
    }
}

class Person {
    // Person class implementation
}