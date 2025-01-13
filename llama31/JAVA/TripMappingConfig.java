import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityManagerFactory;

public class TripMappingConfig {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = // initialize the entityManagerFactory
        entityManagerFactory.addNamedQuery("TripResults", 
            new SqlResultSetMapping("TripResults", 
                new EntityResult(TripEntity.class), 
                new EntityResult(CommercialTripEntity.class)));
    }
}