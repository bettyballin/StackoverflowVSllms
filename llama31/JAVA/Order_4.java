import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedBy;
import java.util.List;

// Order.java
@Entity
public class Order_4 {
    @Id
    private Long id;
    private String customerName;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public static void main(String[] args) {
    }
}

// OrderItem.java
@Entity
public class Order_4Item {
    @Id
    private Long id;
    private String productName;
    @ManyToOne
    private Order order;

    public static void main(String[] args) {
    }
}