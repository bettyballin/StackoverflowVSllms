import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Type;

@Entity
public class MyEntity_7_7 {
    @Id
    @Type(type = "uuid-binary")
    private byte[] id;

    // getters and setters

    public static void main(String[] args) {
    }
}