import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ElementCollection
    @CollectionTable(name = "virtual_column_data",
            joinColumns = @JoinColumn(name = "company_id"))
    private List<VirtualColumnData> virtualColumnData;

    // getters and setters

    public static void main(String[] args) {
    }
}

class Owner {
    // Add properties and getters/setters as needed
}

class VirtualColumnData {
    // Add properties and getters/setters as needed
}