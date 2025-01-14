import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

// Example of a simple entity class that might be persisted
class Content {
    private long id;
    private String data;

    // Getters and setters...
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class JDOPersistenceExample {
    public static void main(String[] args) {
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("myPersistenceUnit");
        PersistenceManager pm = pmf.getPersistenceManager();

        try {
            pm.currentTransaction().begin();
            Content content = new Content();
            content.setData("Normalized Data"); // Replace with actual data
            pm.makePersistent(content);
            pm.currentTransaction().commit();
        } finally {
            pm.close();
        }
    }
}