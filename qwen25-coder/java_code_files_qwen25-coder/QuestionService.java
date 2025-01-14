import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class QuestionService {

    public List<Question> getRandomQuestions(Session session, int testId) {
        Query<Question> query = session.createQuery("FROM Question q WHERE q.testId = :testId", Question.class);
        query.setParameter("testId", testId);

        // Fetch all matching questions
        List<Question> questions = query.getResultList();

        // Shuffle to get random order
        Collections.shuffle(questions);

        // Return the first 10 elements
        return questions.subList(0, Math.min(10, questions.size()));
    }

    // Inner classes to make code executable
    public static class Question {
        public int testId;
        // other fields
    }

    public static class Session {
        public <T> Query<T> createQuery(String hql, Class<T> clazz) {
            return new Query<T>();
        }
    }

    public static class Query<T> {
        public void setParameter(String name, Object value) {
            // implementation
        }

        public List<T> getResultList() {
            return new ArrayList<T>();
        }
    }
}