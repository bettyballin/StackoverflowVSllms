import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Order_1_1 {
    @OneToMany(mappedBy = "order")
    private List<Item> items;

    public static void main(String[] args) {
    }
}