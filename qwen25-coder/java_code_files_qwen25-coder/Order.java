import java.lang.String;
import java.lang.annotation.*;

/**
 * Order entity representing orders placed by customers.
 */
@Entity
public class Order {

    /**
     * Unique identifier for the order.
     */
    @Id
    private Long id;

    /**
     * ID of the customer who placed the order.
     */
    private Long customerId;

    public static void main(String[] args) {
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Entity {
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Id {
}