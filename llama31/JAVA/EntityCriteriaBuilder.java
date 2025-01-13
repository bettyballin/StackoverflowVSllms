import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EntityCriteriaBuilder {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(YourEntity.class);
        criteria.add(Restrictions.eq("active", true));

        session.close();
        sessionFactory.close();
    }
}