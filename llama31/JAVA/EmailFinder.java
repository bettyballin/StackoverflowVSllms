import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmailFinder {
    private EntityManager entityManager;
    private Object folder;

    public EmailFinder(EntityManager entityManager, Object folder) {
        this.entityManager = entityManager;
        this.folder = folder;
    }

    public void findEmails() {
        Query query = entityManager.createNamedQuery("Folder.findEmails");
        query.setParameter("folder", folder);
        List<Object[]> results = query.getResultList();
        // Process the results
    }

    public static void main(String[] args) {
        // Create an instance of EntityManager and folder object
        // EntityManager entityManager = Persistence.createEntityManagerFactory("your_persistence_unit").createEntityManager();
        // Object folder = new Folder(); // Replace with your actual folder object
        // EmailFinder emailFinder = new EmailFinder(entityManager, folder);
        // emailFinder.findEmails();
    }
}