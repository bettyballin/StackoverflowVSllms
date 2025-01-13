import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarRepository {
    private EntityManager entityManager;

    public CarRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = emf.createEntityManager();
    }

    public List<Car> findCarsFilterByTypes(CarType[] types) {
        List<CarType> typeList = Arrays.asList(types);
        return (List<Car>) this.entityManager.createNamedQuery("dealership.findCarsFilterByTypes")
                .setParameter("types", typeList).getResultList();
    }

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        // Use carRepository as needed
    }
}