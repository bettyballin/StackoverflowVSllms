import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class DateQueryHelper {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2009);
        calendar.set(Calendar.MONTH, 5); // 0-based
        calendar.set(Calendar.DAY_OF_MONTH, 11);

        Date date = calendar.getTime();

        Session session = null; // Initialize your Hibernate session here
        Query query = session.createQuery("FROM table WHERE TRUNC(date) = :date");
        query.setParameter("date", date);
    }
}