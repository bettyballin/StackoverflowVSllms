import java.util.List;

public class MessageProcessor {

    private EntityManagerFactory emf;

    public MessageProcessor(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void processMessages(List<MessageData> messageDatas) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            for (int i = 0; i < messageDatas.size(); i++) {
                MessageData messageData = messageDatas.get(i);

                User sender = findUser(em, messageData.getSource());
                User recipient = findUser(em, messageData.getDestination());

                Message message = new Message();
                message.setText(messageData.getText());
                message.setSender(sender);
                message.setRecipient(recipient);

                em.persist(message);

                // Commit batch
                if (i % 100 == 0 && i > 0) {
                    tx.commit();
                    tx.begin();
                }
            }

            // Final commit
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    private User findUser(EntityManager em, Long userId) {
        return em.find(User.class, userId);
    }

    public static void main(String[] args) {
        // For testing purposes, you can add code here
    }
}

// Define MessageData class
class MessageData {
    private Long source;
    private Long destination;
    private String text;

    public MessageData(Long source, Long destination, String text) {
        this.source = source;
        this.destination = destination;
        this.text = text;
    }

    public Long getSource() {
        return source;
    }

    public Long getDestination() {
        return destination;
    }

    public String getText() {
        return text;
    }
}

// Define User class
class User {
    // For simplicity, assume necessary fields and methods
}

// Define Message class
class Message {
    private String text;
    private User sender;
    private User recipient;

    public void setText(String text) {
        this.text = text;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}

// Dummy implementations for compilation purposes
class EntityManagerFactory {
    public EntityManager createEntityManager() {
        return new EntityManager();
    }
}

class EntityManager {
    public EntityTransaction getTransaction() {
        return new EntityTransaction();
    }

    public void persist(Object obj) {
        // Do nothing
    }

    public void close() {
        // Do nothing
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        // Return null for simplicity
        return null;
    }
}

class EntityTransaction {
    public void begin() {
        // Do nothing
    }

    public void commit() {
        // Do nothing
    }

    public void rollback() {
        // Do nothing
    }

    public boolean isActive() {
        return false;
    }
}