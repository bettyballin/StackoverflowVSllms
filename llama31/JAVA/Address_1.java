// Example of a domain model in Java
public class Address_1 {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}

public class Customer {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Anytown", "USA");
        Customer customer = new Customer("John Doe", address);
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress().getStreet() + ", " + customer.getAddress().getCity() + ", " + customer.getAddress().getCountry());
    }
}