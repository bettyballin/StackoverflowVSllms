import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class OrderTest {
    @Test
    public void should_allow_order_to_be_placed() {
        // Given
        Order order = new Order();

        // When
        order.place();

        // Then
        assertThat(order.getStatus(), is(OrderStatus.PLACED));
    }

    public static void main(String[] args) {
    }
}

class Order {
    private OrderStatus status;

    public void place() {
        status = OrderStatus.PLACED;
    }

    public OrderStatus getStatus() {
        return status;
    }
}

enum OrderStatus {
    PLACED
}