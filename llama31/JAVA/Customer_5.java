// Define the CustomerType enum
enum CustomerType {
    // Add your customer types here, e.g.
    REGULAR, PREMIUM, VIP
}

public class Customer_5 {
    private CustomerType type;

    public Customer(CustomerType type) {
        this.type = type;
    }

    public CustomerType getType() {
        return type;
    }

    public static void main(String[] args) {
        // Example usage:
        Customer customer = new Customer(CustomerType.PREMIUM);
        System.out.println(customer.getType());
    }
}