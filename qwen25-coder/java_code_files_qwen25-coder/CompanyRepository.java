import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findAllWithExtensions() {
        return entityManager.createQuery(
            "SELECT c FROM Company c LEFT JOIN FETCH c.extensionValues", 
            Company.class
        ).getResultList();
    } 

    public static void main(String[] args) {
    }
}

class Company {
    // Class definition goes here
}