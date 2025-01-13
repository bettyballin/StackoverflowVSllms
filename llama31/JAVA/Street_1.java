import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Street", schema = "your_schema")
public class Street_1_1 {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    // ...

	public static void main(String[] args) {
	}
}