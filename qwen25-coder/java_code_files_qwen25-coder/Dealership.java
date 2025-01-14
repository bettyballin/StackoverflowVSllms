import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Dealership {

    private EntityManager entityManager;

    public Dealership(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> findCarsFilterByTypes(CarType[] types) {
        // Convert array to list
        List<CarType> typesList = Arrays.asList(types);
        
        // Create a typed query and set the parameter
        TypedQuery<Car> query = this.entityManager.createNamedQuery("dealership.findCarsFilterByTypes", Car.class)
                .setParameter(1, typesList);
        return query.getResultList();
    }
}

// Placeholder class definitions for compilation
class Car {
    // Class body (fields and methods)
}

class CarType {
    // Class body (fields and methods)
}