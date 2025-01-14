import java.util.List;
import java.util.ArrayList;
// Case with interfaces for extensibility

interface IOrder {
    String getId();
    double getAmount();
}

class Order_2 implements IOrder {
    private String id;
    private double amount;

    public Order_2(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}

interface ICustomer {
    void addOrder(IOrder order);
    List<IOrder> getOrders();
}

public class Customer implements ICustomer {
    private String name;
    private List<IOrder> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(IOrder order) {
        orders.add(order);
    }

    @Override
    public List<IOrder> getOrders() {
        return orders;
    }

	public static void main(String[] args) {
	}
}