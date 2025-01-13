import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class PersonDao_1_1 {
    public static void main(String[] args) {
        // Create a Hibernate session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a session
        Session session = sessionFactory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Query<Person> query = session.createQuery("from Person p where lower(p.city) like :search", Person.class);
        query.setParameter("search", "%fran%");

        List<Person> results = query.list();

        // Print the results
        for (Person person : results) {
            System.out.println(person);
        }

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}