import java.util.List;
import java.util.ArrayList;

public interface IOrder {
    // common order methods
}

public class SalesOrder implements IOrder {
    // implementation
}

public class PurchaseOrder implements IOrder {
    // implementation
}

public class Customer {
    private List<IOrder> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public List<IOrder> getOrders() {
        return orders;
    }

    public void addOrder(IOrder order) {
        orders.add(order);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.addOrder(new SalesOrder());
        customer.addOrder(new PurchaseOrder());
    }
}