import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

public class EmailRepository {

    EntityManager entityManager; // Assume this is initialized elsewhere

    public void queryEmails(Long folderId) {

        TypedQuery<LightEmail> query = entityManager.createQuery(
            "SELECT new com.yourpackage.LightEmail(e.senderName, e.subject, e.sentDate) " +
            "FROM Email e JOIN e.folder f WHERE f.id = :folderId", LightEmail.class);

        query.setParameter("folderId", folderId);
        List<LightEmail> lightEmails = query.getResultList();

        // Further processing can be done here
    }

    public static void main(String[] args) {
        EmailRepository repo = new EmailRepository();
        repo.queryEmails(123L);
    }
}

// Placeholder class definitions to make the code compile
class LightEmail {
    String senderName;
    String subject;
    java.util.Date sentDate;

    public LightEmail(String senderName, String subject, java.util.Date sentDate) {
        this.senderName = senderName;
        this.subject = subject;
        this.sentDate = sentDate;
    }
}

class Email {
    // Fields and methods as required
}

class Folder {
    // Fields and methods as required
}