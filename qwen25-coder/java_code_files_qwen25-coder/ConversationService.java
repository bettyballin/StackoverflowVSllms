import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ConversationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void startConversation() {
        // Perform operations that involve multiple requests
        // This transaction is open for the duration of the conversation
    }

    @Transactional(readOnly = true)
    public Data fetchLatestData() {
        // Fetch data within a read-only transaction
        // This can be part of multiple interactions in the same conversation
        return entityManager.find(Data.class, 1L);
    }

    public static void main(String[] args) {
    }
}

// Define the Data class
class Data {
}