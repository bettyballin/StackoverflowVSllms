import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_10_10 {
    private int id;

    @Id
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public static void main(String[] args) {
    }
}