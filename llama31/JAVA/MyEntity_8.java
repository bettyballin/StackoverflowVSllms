import java.lang.String;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Type;

@Entity
public class MyEntity_8_8 {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    // getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public static void main(String[] args) {
    }
}