import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProjectQueryFactory {
    private Session session; // Session object should be injected or created

    public Query createQuery() {
        Query query = session.createQuery("from com.ep.cqprojects.db.Projects "
                + "where DATEDIFF(active_date, kickoff_meeting_date) < 30");
        return query;
    }

    public static void main(String[] args) {
        // To make this code executable, you need to create a Session object
        // and instantiate the ProjectQueryFactory class
        // For demonstration purposes, I'll assume you have a HibernateUtil class
        // that provides a Session object
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProjectQueryFactory factory = new ProjectQueryFactory();
        factory.session = session;
        Query query = factory.createQuery();
        // Now you can use the query object
    }
}