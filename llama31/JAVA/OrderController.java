import java.lang.String;
import java.lang.Integer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @PostMapping("/{orderId}/add-orderline")
    public Order addOrderLine(@PathVariable Long orderId, @RequestParam Long productId, @RequestParam Integer quantity) {
        // validate and add order line to order
        return null; // Return statement added to make the code compile
    }

	public static void main(String[] args) {
	}
}

// Assuming Order is a custom class, adding a basic definition for it
class Order {
    // Add properties and methods as per your requirement
}