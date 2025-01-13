// User.java
public class User_39 {
    private String name;
    private UserAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }
}

// UserAddress.java
public class User_39Address {
    private String street;
    private String city;

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

    public static void main(String[] args) {
        User user = new User();
        UserAddress address = new UserAddress();
        address.setStreet("123 Main St");
        address.setCity("Anytown");
        user.setAddress(address);
        user.setName("John Doe");
        System.out.println("User Name: " + user.getName());
        System.out.println("User Address: " + user.getAddress().getStreet() + ", " + user.getAddress().getCity());
    }
}