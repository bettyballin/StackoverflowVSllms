import java.lang.String;

// Service layer (SOA)
interface OrderService {
    void placeOrder(Order order);
}

class OrderServiceImpl implements OrderService {
    // Business logic to place an order
    @Override
    public void placeOrder(Order order) {
        // Add your business logic here
    }
}

// MVC/MVP pattern
class OrderModel {
    private String orderId;
    private String customerName;
    // getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

class Order {
    // Define your Order class here
    private String orderId;
    private String customerName;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

class OrderController {
    private OrderService orderService;
    
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    public void placeOrder(OrderModel order) {
        Order orderToPlace = new Order(order.getOrderId(), order.getCustomerName());
        orderService.placeOrder(orderToPlace);
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderController orderController = new OrderController(orderService);
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId("123");
        orderModel.setCustomerName("John Doe");
        orderController.placeOrder(orderModel);
    }
}