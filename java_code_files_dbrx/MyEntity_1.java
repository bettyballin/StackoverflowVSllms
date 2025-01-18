import org.hibernate.annotations.Entity;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MyEntity_1 {
    public static void main(String[] args) {
    }
}