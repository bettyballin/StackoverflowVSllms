import java.util.List;

// Mocked external classes

// Simulate org.hibernate.Session
class Session {
    public <T> NativeQuery<T> createSQLQuery(String sql) {
        return new NativeQuery<>();
    }
}

// Simulate org.hibernate.query.NativeQuery
class NativeQuery<T> {
    public NativeQuery<T> addEntity(Class<T> entityClass) {
        return this;
    }
    public NativeQuery<T> setParameter(String name, Object value) {
        return this;
    }
    public List<T> getResultList() {
        return null;
    }
}

// The Question class
class Question {
    // Empty implementation
}

public class SomeClass {

    public List<Question> getRandomQuestions(Session session, int testId) {
        NativeQuery<Question> nativeQuery = session.createSQLQuery("SELECT * FROM QUESTION WHERE TESTID= :testId ORDER BY RAND() LIMIT 10")
                .addEntity(Question.class);
        nativeQuery.setParameter("testId", testId);

        // Execute the query and get a list of questions
        return nativeQuery.getResultList();
    }
}