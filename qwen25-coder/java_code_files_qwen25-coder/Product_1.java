import java.lang.String;
import javax.persistence.Entity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product_1 {
    // product fields and mappings

    public static void main(String[] args) {
    }
}