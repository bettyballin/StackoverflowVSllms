import javax.persistence.Entity;
import javax.persistence.Where;

@Entity
@Where(clause = "is_deleted = 0")
public class MyEntity_11_11 {
    // ...

    public static void main(String[] args) {
    }
}