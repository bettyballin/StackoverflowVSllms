import java.lang.String;

public interface OrderService {
    void persistOrder(Order order);
}

public class Order {
    // class definition
}

public class Database {
    public void insertInto(String tableName, Order order) {
        // method body
    }
}

public class OrderServiceImpl implements OrderService {
    private final Database database; //Inject mock database during testing

    public OrderServiceImpl(Database database) {
        this.database = database;
    }

    private void validateOrder(Order order) {
        // method body
    }

    @Override
    public void persistOrder(Order order) {
        validateOrder(order);
        database.insertInto("orders", order);
    }

    public static void main(String[] args) {
        Database database = new Database();
        OrderService orderService = new OrderServiceImpl(database);
        Order order = new Order();
        orderService.persistOrder(order);
    }
}