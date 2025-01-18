import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.example.LightEmail;

public class EmailRepository {

    private EntityManager entityManager;

    public List<LightEmail> getAllSentDatesInFolder(long folderId) {
        String jpql = "SELECT new com.example.LightEmail(" +
            "e.senderName," +
            "e.subject," +
            "e.sentDate" +
        ") FROM Email e WHERE e.folder.id = :folderId";
        TypedQuery<LightEmail> query = entityManager.createQuery(jpql, LightEmail.class);
        query.setParameter("folderId", folderId);
        return query.getResultList();
    }

    public static void main(String[] args) {
    }
}