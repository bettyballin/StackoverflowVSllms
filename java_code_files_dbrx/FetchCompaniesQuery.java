import java.util.List;

public class FetchCompaniesQuery {
    EntityManager em = new EntityManager();
    TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c LEFT JOIN FETCH c.additionalProperties", Company.class);
    List<Company> companies = query.getResultList();

    public static void main(String[] args) {
    }
}

class Company {
    // Define any necessary fields or methods here
}

class EntityManager {
    public <T> TypedQuery<T> createQuery(String queryStr, Class<T> resultClass) {
        return new TypedQuery<T>();
    }
}

class TypedQuery<T> {
    public List<T> getResultList() {
        return null; // Replace with actual implementation if available
    }
}