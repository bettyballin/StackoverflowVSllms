// Define the Address class
class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

// Define the PersistenceException class
class PersistenceException extends Exception {
    public PersistenceException(String message) {
        super(message);
    }
}

// Define the AddressBookService class
public class AddressBookService {
    /**
     * @throws IllegalArgumentException if addy is null or invalid
     * @throws PersistenceException if db layer encounters a problem
     */
    public Address addAddress(Address addy) throws PersistenceException {
        if (addy == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        // Simulate adding the address to the database
        // In a real application, you would replace this with actual database code
        System.out.println("Adding address to database...");
        return addy;
    }

    public static void main(String[] args) {
        AddressBookService service = new AddressBookService();
        Address address = new Address("123 Main St", "Anytown", "CA", "12345");
        try {
            service.addAddress(address);
        } catch (PersistenceException e) {
            System.out.println("Error adding address: " + e.getMessage());
        }
    }
}