import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class YourEntity_12 {
    
    @Id
    @GeneratedValue(generator = "custom_id_generator")
    private Long id;
    
    // other properties and methods
    

	public static void main(String[] args) {
	}
}