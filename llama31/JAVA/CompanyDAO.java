import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyDAO {
    private EntityManager entityManager;

    public CompanyDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = emf.createEntityManager();
    }

    public Company getCompany(Long id) {
        return entityManager.find(Company.class, id);
    }

    public static void main(String[] args) {
        CompanyDAO dao = new CompanyDAO();
        // Use the dao object to call the getCompany method
    }
}