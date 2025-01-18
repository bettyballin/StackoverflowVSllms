import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class MyJpaClass_1 {
    @Id
    @GenericGenerator(name = "myUUID", strategy = "uuid")
    @GeneratedValue(generator = "myUUID")
    @Column(columnDefinition = "VARCHAR(36)", name = "id")
    private String id;

    public static void main(String[] args) {
    }
}