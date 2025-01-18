import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity // specifies that this annotated class is a persistent entity.
public class Person {
    private long id;
    private String firstName;
    private String lastName;

    @Id // specify the primary key in table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specify the strategy for generating unique keys (AUTO, IDENTITY etc.).
    public long getId() {
        return id;
    }
}