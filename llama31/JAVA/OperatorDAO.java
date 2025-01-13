import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class OperatorDAO {
    private SessionFactory sessionFactory;

    public OperatorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void execute() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Operator.class);
        // ... build up the criteria ...

        String sql = session.getNamedQuery("SQL").getQueryString();
    }

    public static void main(String[] args) {
        // Create a SessionFactory instance
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create an instance of OperatorDAO
        OperatorDAO operatorDAO = new OperatorDAO(sessionFactory);

        // Call the execute method
        operatorDAO.execute();
    }
}