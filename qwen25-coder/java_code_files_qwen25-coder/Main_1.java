import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new SessionFactory();
        Session session = sessionFactory.openSession();
        session.enableFilter("deletedBarFilter").setParameter("isDeleted", false);

        int fooId = 1; // Example fooId
        Foo foo = session.get(Foo.class, fooId);
        List<Bar> bars = foo.getBars(); // This will only include non-deleted bars.
    }
}

class SessionFactory {
    public Session openSession() {
        return new Session();
    }
}

class Session {
    public Filter enableFilter(String name) {
        return new Filter();
    }

    public <T> T get(Class<T> clazz, int id) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}

class Filter {
    public Filter setParameter(String name, Object value) {
        return this;
    }
}

class Foo {
    public List<Bar> getBars() {
        return java.util.Arrays.asList(new Bar(), new Bar());
    }
}

class Bar {
}