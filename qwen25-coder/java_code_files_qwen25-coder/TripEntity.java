import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;

// Place this at the class level, outside of any method
@Entity
@Table(name = "trip") // assuming your main entity table name is trip
@SqlResultSetMapping(
    name = "TripResults",
    entities = {
        @EntityResult(entityClass = TripEntity.class)
    }
)
class TripEntity {
    // Entity fields and methods
}

// Similarly, if CommercialTripEntity needs to be mapped, it should be done separately
@Entity
@Table(name = "commercial_trip")
@SqlResultSetMapping(
    name = "CommercialTripResults",
    entities = {
        @EntityResult(entityClass = CommercialTripEntity.class)
    }
)
public class CommercialTripEntity {
    // Entity fields and methods

    public static void main(String[] args) {
    }
}