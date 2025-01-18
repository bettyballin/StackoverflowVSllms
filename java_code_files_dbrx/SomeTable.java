import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
public class SomeTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // other fields, constructors, getters and setters...

    @Version
    private Timestamp version;  // optimistic lock field with timestamps instead of counters - good fit for frequently read entities

    public static void main(String[] args) {
    }
}