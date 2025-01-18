import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BatchConfigurator {
    Map props = new HashMap();
    EntityManagerFactory factory;

    {
        props.put("toplink.write-batches", "true"); // Enable Batch Writing for inserts
        factory = Persistence.createEntityManagerFactory("yourPersistenceUnitName", props);
    }

    public static void main(String[] args) {
    }
}