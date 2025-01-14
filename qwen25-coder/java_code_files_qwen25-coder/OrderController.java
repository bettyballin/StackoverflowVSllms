import java.lang.String;

public class OrderController {
    // Example using REST controller in Java/Spring
    @PostMapping("/orders/{orderId}/order-lines")
    public ResponseEntity<OrderLine> addOrderLine(@PathVariable Long orderId, @RequestBody OrderLineDTO orderLineDTO) {
        // Logic to add the order line to the order
        return null; // placeholder to make it compile
    }
    public static void main(String[] args) {
    }
}

@interface PostMapping {
    String value();
}

@interface PathVariable {
}

@interface RequestBody {
}

class ResponseEntity<T> {
}

class OrderLine {
}

class OrderLineDTO {
}