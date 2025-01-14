import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Table(name = "SLAVE")
public class ScenarioSlave_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
        @JoinColumn(name = "sName", referencedColumnName = "sName"),
        @JoinColumn(name = "sNumber", referencedColumnName = "sNumber")
    })
    private ScenarioMaster master;

    // Existing fields...

    // Getters and setters

    public static void main(String[] args) {
    }
}

class ScenarioMaster {
    // Empty class to enable compilation
}