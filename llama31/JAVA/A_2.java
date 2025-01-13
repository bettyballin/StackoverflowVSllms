import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "A.findWithBCount", query = "SELECT a, (SELECT COUNT(b) FROM B b WHERE b.a = a) as bCount FROM A a")
public class A_2_2 {
    // ...

    public static void main(String[] args) {
    }
}