import java.util.Set;
import java.util.HashSet;

public class Customer {
    // Other fields...

    private Set<Address> addresses = new HashSet<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        if (address.getCustomer() != this) {
            address.setCustomer(this);
        }
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public static void main(String[] args) {
    }
}

class Address {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}