import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "SLAVE")
public class ScenarioSlave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sName", nullable = false, updatable = false)
    private String sName;

    @Column(name = "sNumber", nullable = false, updatable = false)
    private long sNumber;

    @Column(name = "sValue")
    private double sValue;

    // Getters and setters

    public static void main(String[] args) {
    }
}