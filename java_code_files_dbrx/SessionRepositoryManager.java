import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.session.ExpiringSession;
import java.util.Optional;

public class SessionRepositoryManager {
    @Autowired
    private SessionRepository<? extends ExpiringSession> sessions; // Injection of the session repository instance
    // ...

    public static void main(String[] args) {
        // Create an instance of SessionRepositoryManager
        SessionRepositoryManager manager = new SessionRepositoryManager();

        // Fetching a stored session object using its ID
        Optional<? extends ExpiringSession> byId = manager.sessions.findById("session_id");
    }
}