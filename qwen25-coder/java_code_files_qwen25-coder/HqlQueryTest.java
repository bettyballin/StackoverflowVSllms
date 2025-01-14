import java.util.List;

public class HqlQueryTest {

    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        if (session != null) session.close();
        if (sessionFactory != null) sessionFactory.close();
    }

    @Test
    public void testHqlQuery() {
        String hql = "FROM YourEntity WHERE someProperty = :value";
        Query<YourEntity> query = session.createQuery(hql, YourEntity.class);
        query.setParameter("value", "expectedValue");
        
        // Execute the query and validate results
        List<YourEntity> result = query.list();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("expectedValue", result.get(0).getSomeProperty());
    }

    public static void main(String[] args) {
    }

    // Annotations
    @interface Before { }
    @interface After { }
    @interface Test { }

    // Assert class
    public static class Assert {
        public static void assertEquals(Object expected, Object actual) {
        }
    }

    // YourEntity class
    public static class YourEntity {
        private String someProperty;

        public String getSomeProperty() {
            return someProperty;
        }

        public void setSomeProperty(String value) {
            this.someProperty = value;
        }
    }

    // Configuration class
    public static class Configuration {
        public Configuration configure() {
            return this;
        }
        public SessionFactory buildSessionFactory() {
            return new SessionFactoryImpl();
        }
    }

    // SessionFactory interface
    public interface SessionFactory {
        Session openSession();
        void close();
    }

    // SessionFactory implementation
    public static class SessionFactoryImpl implements SessionFactory {
        public Session openSession() {
            return new SessionImpl();
        }
        public void close() {
        }
    }

    // Session interface
    public interface Session {
        <T> Query<T> createQuery(String hql, Class<T> clazz);
        void close();
    }

    // Session implementation
    public static class SessionImpl implements Session {
        public <T> Query<T> createQuery(String hql, Class<T> clazz) {
            return new QueryImpl<>();
        }
        public void close() {
        }
    }

    // Query interface
    public interface Query<T> {
        void setParameter(String name, Object value);
        List<T> list();
    }

    // Query implementation
    public static class QueryImpl<T> implements Query<T> {
        public void setParameter(String name, Object value) {
        }
        public List<T> list() {
            return java.util.Collections.emptyList();
        }
    }
}