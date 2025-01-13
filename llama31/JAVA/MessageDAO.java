import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// Assuming Message class is defined elsewhere
public class MessageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Message> getMessages(int offset, int limit) {
        Session session = sessionFactory.getCurrentSession();
        Query<Message> query = session.createQuery("FROM Message m ORDER BY m.timestamp DESC", Message.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public Message getMessage(Long messageId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Message.class, messageId);
    }

    public static void main(String[] args) {
        // This main method is left empty as per the original code
    }
}