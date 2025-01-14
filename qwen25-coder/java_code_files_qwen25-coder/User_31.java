import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Marks this class as a persistent entity in the database
public class User_31 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    // Getters and setters

	public static void main(String[] args) {
	}
}