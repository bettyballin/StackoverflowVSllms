import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_7 {
    @Id // Must keep since it's essential and simple
    private Long id;
    
    private String name;
    
    // Other fields...

    public static void main(String[] args) {
    }
}