import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CarRepository_1_1 {
    private EntityManager entityManager;

    public CarRepository_1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = emf.createEntityManager();
    }

    public List<Car> findCarsFilterByTypes(CarType[] types) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> cq = cb.createQuery(Car.class);
        Root<Car> car = cq.from(Car.class);
        cq.where(car.get("type").in(Arrays.asList(types)));
        cq.orderBy(cb.asc(car.get("model")));
        return entityManager.createQuery(cq).getResultList();
    }

    public static void main(String[] args) {
        CarRepository_1 carRepository = new CarRepository_1();
        // Use carRepository as needed
    }
}