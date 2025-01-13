import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class QuestionRandomizer {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // Your original code
        Query<Question> query = session.createQuery("from Question q where q.testId = 1 order by RAND()", Question.class);
        query.setMaxResults(10);
        List<Question> randomQuestions = query.list();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}