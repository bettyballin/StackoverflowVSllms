import java.util.List;

public class FetchTestResultsQuery {
    public static void main(String[] args) {
        String hql = "from Test t left join fetch t.testExtension";
        Session session = new Session(); // Placeholder session
        Query<Test> query = session.createQuery(hql, Test.class);
        List<Test> results = query.list();
    }

    public static class Session {
        public <T> Query<T> createQuery(String hql, Class<T> clazz) {
            return new Query<T>();
        }
    }

    public static class Query<T> {
        public List<T> list() {
            return null; // Placeholder implementation
        }
    }

    public static class Test {
        // Empty class for compilation
    }
}