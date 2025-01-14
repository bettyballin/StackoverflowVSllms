import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "your_sql_view_name")
public class YourEntity_3 {

    @Id
    private Long id; // This should be a unique identifier in your view, maybe use a composite key if needed

    // other columns from the view as fields

    // getters and setters

	public static void main(String[] args) {
	}
}