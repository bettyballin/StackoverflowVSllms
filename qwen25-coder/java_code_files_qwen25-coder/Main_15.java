import java.util.Arrays;
import java.util.List;
// import javax.persistence.EntityManager;
// import javax.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {
        // Assuming 'em' is your EntityManager instance
        EntityManager em = new EntityManager(); // Placeholder for EntityManager instance

        List<Integer> values = Arrays.asList(1, 2, 3);
        TypedQuery<tableA> query = em.createQuery(
            "SELECT tab FROM tableA tab WHERE tab.colA IN (:colValues)", tableA.class);
        query.setParameter("colValues", values);
    }
}

class tableA {
    // Define fields and methods as needed
}

class EntityManager {
    public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        // Dummy implementation
        return new TypedQuery<T>();
    }
}

class TypedQuery<T> {
    public void setParameter(String name, Object value) {
        // Dummy implementation
    }
}