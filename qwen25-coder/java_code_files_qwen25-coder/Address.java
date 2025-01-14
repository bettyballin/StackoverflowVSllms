import java.lang.String;
public class Address {
    // Other fields...

    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static void main(String[] args) {
    }
}

class Customer {
    // Empty class
}