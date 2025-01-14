import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Column;

@Entity
public class Street {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    @OneToMany(mappedBy="street")
    public Set<House> houses;

    // Add a non-id column with a default value
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Unnamed Street'")
    private String name;

    public static void main(String[] args) {
    }
}

class House {
    private Street street;
}