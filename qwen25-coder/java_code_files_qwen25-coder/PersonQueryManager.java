import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PersonQueryManager {
    String hql = "FROM Person p WHERE LOWER(p.city) LIKE :city";
    Session session;
    String city;

    {
        Query<Person> query = session.createQuery(hql, Person.class);
        query.setParameter("city", "%" + city.toLowerCase() + "%");

        List<Person> results = query.getResultList();
    }

    public static void main(String[] args) {
    }
}