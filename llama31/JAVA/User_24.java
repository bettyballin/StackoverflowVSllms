import java.lang.String;

public class User_24 {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public static class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public String getStreet() {
            return street;
        }
    }

    public static void main(String[] args) {
        User user = new User("John Doe", null); // User without an address
        if (user.getAddress() != null) {
            System.out.println(user.getAddress().getStreet());
        } else {
            System.out.println("No address available");
        }
    }
}