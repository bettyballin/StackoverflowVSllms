import java.lang.String;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class EntityIdGenerator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public static void main(String[] args) {
    }
}