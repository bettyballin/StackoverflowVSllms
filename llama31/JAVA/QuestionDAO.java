import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class QuestionDAO {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Question> query = session.createQuery("FROM Question q WHERE q.testId = :testId ORDER BY RAND()", Question.class);
        query.setParameter("testId", 1);
        query.setMaxResults(10);
        List<Question> randomQuestions = query.list();
        session.close();
    }
}