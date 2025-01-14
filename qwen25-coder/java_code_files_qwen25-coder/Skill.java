import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    private Long id;
    private String name;
    private String description;

    // Getters and setters omitted for brevity

	public static void main(String[] args) {
	}
}