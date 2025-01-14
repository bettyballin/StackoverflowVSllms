// Specification.java
public interface Specification<T> {
    boolean isSatisfiedBy(T candidate);
}

// Customer.java
public class Customer {
    // Customer properties and methods
}

// ValidCustomerSpecification.java
public class ValidCustomerSpecification implements Specification<Customer> {
    @Override
    public boolean isSatisfiedBy(Customer customer) {
        // Validation logic for customer
        return true;
    }
}

// Order.java
public class Order {
    // Order properties and methods
}

// ValidOrderForCustomerSpecification.java
public class ValidOrderForCustomerSpecification implements Specification<Order> {
    private Customer customer;

    public ValidOrderForCustomerSpecification(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean isSatisfiedBy(Order order) {
        // Validation logic for order based on customer
        return true;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Order order = new Order();

        ValidCustomerSpecification customerSpec = new ValidCustomerSpecification();
        ValidOrderForCustomerSpecification orderSpec = new ValidOrderForCustomerSpecification(customer);

        boolean isCustomerValid = customerSpec.isSatisfiedBy(customer);
        boolean isOrderValid = orderSpec.isSatisfiedBy(order);

        System.out.println("Is customer valid? " + isCustomerValid);
        System.out.println("Is order valid? " + isOrderValid);
    }
}