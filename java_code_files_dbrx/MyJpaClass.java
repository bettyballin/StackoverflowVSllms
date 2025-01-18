import java.lang.String;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class MyJpaClass {
    @Id
    @GenericGenerator(name="myUUID", strategy = "uuid")
    @GeneratedValue(generator = "myUUID")
    private BigInteger id;

    public static void main(String[] args) {
    }
}