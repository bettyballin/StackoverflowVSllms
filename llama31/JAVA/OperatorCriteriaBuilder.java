import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criteria;
import org.hibernate.criterion.Restrictions;

public class OperatorCriteriaBuilder {
    private Session session;

    public OperatorCriteriaBuilder() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        session = sessionFactory.openSession();
    }

    public void buildCriteria() {
        Criteria criteria = session.createCriteria(Operator.class);
        // ... build up the criteria ...

        String sql = (String) criteria.get("SQL");
        System.out.println(sql);
    }

    public static void main(String[] args) {
        OperatorCriteriaBuilder ocb = new OperatorCriteriaBuilder();
        ocb.buildCriteria();
    }
}