import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CustomerDAO_2_2 {
    // Using an ORM (e.g., Hibernate) to perform the same query
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query<Customer> query = session.createQuery("FROM Customer c WHERE c.country='USA' AND c.age>18 ORDER BY c.lastName ASC", Customer.class);
        List<Customer> customers = query.list();

        session.getTransaction().commit();
        session.close();
    }
}