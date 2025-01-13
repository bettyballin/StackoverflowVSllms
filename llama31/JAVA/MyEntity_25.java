import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
    name="TripResults",
    entities={
        @EntityResult(entityClass=TripEntity.class),
        @EntityResult(entityClass=CommercialTripEntity.class)
    }
)
public class MyEntity_25_25 {
    //...

	public static void main(String[] args) {
	}
}