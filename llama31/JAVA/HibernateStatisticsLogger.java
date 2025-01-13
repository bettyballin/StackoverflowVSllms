import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

public class HibernateStatisticsLogger {
    private SessionFactory sessionFactory;

    public HibernateStatisticsLogger(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void logStatistics() {
        Statistics stats = sessionFactory.getStatistics();
        stats.logSummary();
    }

    public static void main(String[] args) {
        // You need to create a SessionFactory instance and pass it to the HibernateStatisticsLogger constructor
        // For example:
        // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // HibernateStatisticsLogger logger = new HibernateStatisticsLogger(sessionFactory);
        // logger.logStatistics();
    }
}