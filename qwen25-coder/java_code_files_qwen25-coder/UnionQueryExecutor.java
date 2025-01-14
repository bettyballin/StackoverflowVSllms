import java.util.List;
import java.util.ArrayList;

public class UnionQueryExecutor {
    // Declare sessionFactory
    SessionFactory sessionFactory = new SessionFactory();

    // Instance initializer block
    {
        Session session = sessionFactory.openSession();
        String sqlQuery = "SELECT field1, field2 FROM (SELECT field1, field2 FROM table1 UNION SELECT field1, field2 FROM table2) AS subquery";
        SQLQuery query = session.createSQLQuery(sqlQuery).addEntity(YourEntity.class);
        List<YourEntity> results = query.list();
        session.close();
    }
    
    public static void main(String[] args) {
    }
}

class SessionFactory {
    public Session openSession() {
        return new Session();
    }
}

class Session {
    public SQLQuery createSQLQuery(String sql) {
        return new SQLQuery();
    }

    public void close() {
        // Close session
    }
}

class SQLQuery {
    public SQLQuery addEntity(Class<?> clazz) {
        return this;
    }

    public List<YourEntity> list() {
        return new ArrayList<YourEntity>(); // Return an empty list
    }
}

class YourEntity {
    // Define entity fields and methods as needed
}