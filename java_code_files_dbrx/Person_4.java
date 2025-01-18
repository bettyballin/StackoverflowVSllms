public class Person_4 {
    private int id;

    // other properties omitted for brevity

    private Address address;

    public Address getAddress() {
        if (address == null) {
            address = new Address(id); // replace with actual loading logic
        }
        return address;
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class Address {
    private int id;

    public Address(int id) {
        this.id = id;
    }

    // other properties and methods omitted for brevity
}