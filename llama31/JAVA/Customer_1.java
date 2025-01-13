import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Customer_1 {
  private String name;
  private String email;
  private List<Order> orders;

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
    this.orders = new ArrayList<>();
  }

  public void addOrder(Order order) {
    this.orders.add(order);
  }
}

class Order {
  private Date orderDate;
  private Customer customer;

  public Order(Date orderDate, Customer customer) {
    this.orderDate = orderDate;
    this.customer = customer;
  }
}

public class Main {
	public static void main(String[] args) {
	}
}