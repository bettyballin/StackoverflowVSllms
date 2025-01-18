public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        String name = "John Doe";
        String address = "123 Main St";
        String phoneNumber = "555-1234";
        String email = "john@example.com";
        customerRepository.save(new Customer(name, address, phoneNumber, email));  // This calls DB inserting method internally or updates using some criteria as implemented in Repository class
    }
}

class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    // Getters and setters (optional)
}

class CustomerRepository {
    public void save(Customer customer) {
        // This calls DB inserting method internally or updates using some criteria as implemented in Repository class
    }
}