import java.util.Set;
import javax.persistence.*;

@Entity
public class Customer_1 {
    @Id
    private Long id;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}

@Entity
public class Order {
    @Id
    private Long id;

    @ManyToOne
    private Customer_1 customer;

    public static void main(String[] args) {
    }
}