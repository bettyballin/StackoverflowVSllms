import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order_2_2 {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public static void main(String[] args) {
    }
}

class Customer {
    // Add customer class definition here
}