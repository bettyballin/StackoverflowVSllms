import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "your_table")
public class YourEntity_10 {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    // properties according to XML

    // getters and setters

	public static void main(String[] args) {
	}
}