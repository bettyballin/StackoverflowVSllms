import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = getCurrentSession(); // get current hibernate session
        Criteria criteria = session.createCriteria(TestExtension.class);
        criteria.addAlias("test", "t");   // assign alias 't' to Test
        criteria.setFetchMode("t", FetchMode.JOIN);   // set fetch mode to JOIN for 't' which is the 'Test' class aliased as 't'
        criteria.createAlias("t", "t", JoinType.LEFT_OUTER_JOIN, Restrictions.isEmpty("t")); // create alias with left outer join type and condition that test_id should not be in t (which means TestExtension will have records without matching Test records)
        List<TestExtension> results = criteria.list();
    }

    private static Session getCurrentSession() {
        // Implement method to get current hibernate session
        return new Session();
    }
}

class Session {
    public Criteria createCriteria(Class<?> clazz) {
        return new Criteria();
    }
}

class Criteria {
    public void addAlias(String associationPath, String alias) {}

    public void setFetchMode(String associationPath, FetchMode mode) {}

    public void createAlias(String associationPath, String alias, JoinType joinType, Criterion withClause) {}

    public List<TestExtension> list() {
        return null;
    }
}

class FetchMode {
    public static final FetchMode JOIN = new FetchMode();
}

class JoinType {
    public static final JoinType LEFT_OUTER_JOIN = new JoinType();
}

class Restrictions {
    public static Criterion isEmpty(String propertyName) {
        return new Criterion();
    }
}

class Criterion {}

class TestExtension {}