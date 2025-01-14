import java.lang.String;
// Import necessary Hibernate and JPA annotations
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
	}
}