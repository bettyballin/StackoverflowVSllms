import java.util.List;
import org.hibernate.Session;
import org.hibernate.SQLQuery;

public class NativeSQLQueryExecutor {
    public static void main(String[] args) {
        String sql = "SELECT o.* from operator o";  // Manually define your native SQL here...
        Session session = null; // Session should be obtained from SessionFactory

        // Create raw SQL query from it...
        SQLQuery query = session.createSQLQuery(sql);

        // Execute and fetch the result set (if any)...
        List resultSet = query.list();
    }
}