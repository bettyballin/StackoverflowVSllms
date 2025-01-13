// DDD example (simplified)
public class Customer_3 {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public boolean isEligibleForDiscount() {
        // apply business rules
        return false; // Replace with actual business logic
    }

    public static void main(String[] args) {
        // Create an instance of Address
        Address address = new Address("123 Main St", "Anytown", "US");

        // Create an instance of Customer
        Customer customer = new Customer("John Doe", address);

        // Check if customer is eligible for discount
        System.out.println(customer.isEligibleForDiscount());
    }
}

class Address {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
}