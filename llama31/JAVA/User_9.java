import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_9_9 {
    @Id
    private int id;

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public static void main(String[] args) {
    }
}