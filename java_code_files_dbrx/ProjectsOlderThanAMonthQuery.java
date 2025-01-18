import java.lang.String;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProjectsOlderThanAMonthQuery {

    Date currentTime = new Date(); // Replace with the desired start time if needed.

    Session session;

    Query query;

    public ProjectsOlderThanAMonthQuery(Session session) {
        this.session = session;
        query = session.createQuery("from com.ep.cqprojects.db.Projects WHERE (active_date - kickoff_meeeting_date)/(24*60*60*1000) < :month")
            .setParameter("month", 30L * 24L * 60L * 60L * 1000); // This is the number of milliseconds in a month.
        // Please note that this value may not be exact due to differences in the length of months, but can serve your purpose if you don't need absolute precision.
    }

    public static void main(String[] args) {
    }
}