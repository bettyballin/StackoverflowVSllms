import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
  name = "findMyEntityByWord",
  query = "SELECT m FROM MyEntity m WHERE m.normalizedWord LIKE :word"
)
public class MyEntity_1 {
    // Your entity implementation here...
}