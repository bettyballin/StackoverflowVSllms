import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyEntity_1 {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // other fields, getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public static void main(String[] args) {
	}
}