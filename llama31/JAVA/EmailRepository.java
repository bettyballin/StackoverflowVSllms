import javax.persistence.Query;
import javax.persistence.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmailRepository extends JpaRepository<Email, Long> {
    @Query("SELECT e.senderName, e.subject, e.sentDate FROM Email e WHERE e.folder = :folder")
    List<Object[]> findEmails(@Param("folder") Folder folder);
}

class Email {
    // Add necessary fields and getters/setters
}

class Folder {
    // Add necessary fields and getters/setters
}

public class Main {
    public static void main(String[] args) {
        // Add code to test the EmailRepository
    }
}