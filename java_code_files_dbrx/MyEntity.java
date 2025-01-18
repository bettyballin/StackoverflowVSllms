// Using JPA Annotation @Immutable to configure MyEntity as a read-only entity.
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity(name = "MyEntity")
@Table(name = "PL_VW")
@Immutable // <-- Pay attention to this line!
public class MyEntity {
    // Your properties, getters & setters...

    public static void main(String[] args) {
    }
}