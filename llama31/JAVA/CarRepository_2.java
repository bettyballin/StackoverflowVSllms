import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CarRepository_2_2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = emf.createEntityManager();

        CarRepository_2 carRepository = new CarRepository_2(entityManager);
        carRepository.createQuery();

        entityManager.close();
        emf.close();
    }

    private final EntityManager entityManager;

    public CarRepository_2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createQuery() {
        Query query = entityManager.createQuery("SELECT c FROM Car c JOIN FETCH c.vehicle");
        // You may want to execute the query and process the results here
    }
}