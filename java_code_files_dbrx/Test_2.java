import java.util.List;

// Mock classes to allow compilation without changing functionality
class Session {
    public Criteria createCriteria(Class<?> clazz) {
        return new Criteria();
    }
}

class Criteria {
    public void addAlias(String associationPath, String alias) {
        // Stub method
    }

    public List<TestExtension> list() {
        return null; // Stub method
    }
}

class TestExtension {
    // Class definition
}

public class Test {
    public static void main(String[] args) {
        // get current hibernate session
        Session session = getCurrentHibernateSession();
        Criteria criteria = session.createCriteria(TestExtension.class);
        criteria.addAlias("test", "t");   // assign alias 't' to Test
        List<TestExtension> results = criteria.list();
    }

    public static Session getCurrentHibernateSession() {
        return new Session(); // Placeholder for actual session retrieval
    }
}