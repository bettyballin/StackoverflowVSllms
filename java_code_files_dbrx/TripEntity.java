import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(name = "TripResults",
    entities = {
        @EntityResult(entityClass = TripEntity.class),
        @EntityResult(entityClass = CommercialTripEntity.class)
    }
)
public class TripEntity {
    // Default constructor
    public TripEntity() {
    }
    
    // Additional fields and methods
}

@Entity
class CommercialTripEntity {
    // Default constructor
    public CommercialTripEntity() {
    }
    
    // Additional fields and methods
}