import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PaginatedQueryExecutor {

    String queryString = "SELECT * FROM (SELECT your_table.*, ROWNUM rnum FROM (SELECT * FROM your_table ORDER BY id) WHERE ROWNUM <= :maxResult) WHERE rnum > :minResult";
    Session session;
    Query query;
    List list;

    public PaginatedQueryExecutor(Session session) {
        this.session = session;
        query = session.createSQLQuery(queryString)
                .setParameter("maxResult", 30)
                .setParameter("minResult", 0);
        list = query.list();
    }

    public static void main(String[] args) {
        Session session = createSession();
        PaginatedQueryExecutor executor = new PaginatedQueryExecutor(session);
    }

    private static Session createSession() {
        // Implement session creation logic here
        return null;
    }
}