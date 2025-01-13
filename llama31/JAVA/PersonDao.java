import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.criteria.HibernateCriteria;
import org.hibernate.query.criteria.Root;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.MatchMode;

public class PersonDao {
    private SessionFactory sessionFactory;

    public PersonDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().getSessionFactoryBuilder().build();
    }

    public List<Person> getPeople() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(Restrictions.ilike("city", "%fran%", MatchMode.ANYWHERE));
        List<Person> results = criteria.list();
        session.getTransaction().commit();
        return results;
    }

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        List<Person> people = personDao.getPeople();
        for (Person person : people) {
            System.out.println(person);
        }
    }
}