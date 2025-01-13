import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProjectQueryDao {
    private Session session;

    public ProjectQueryDao(Session session) {
        this.session = session;
    }

    public void queryProjects() {
        Query query = session.createQuery("from com.ep.cqprojects.db.Projects "
                + "where ABS(DATEDIFF(active_date, kickoff_meeting_date)) < 30");
        // You can execute the query and process the results here
    }

    public static void main(String[] args) {
        // You need to create a Hibernate session factory and open a session
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        ProjectQueryDao projectQueryDao = new ProjectQueryDao(session);
        projectQueryDao.queryProjects();

        session.close();
        sessionFactory.close();
    }
}