import java.util.ArrayList;
import java.util.Set;

@interface Transactional {
}

class Customer {
    private Set<Address> addresses;
    private boolean disabled;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}

class Address {
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

class Session {
    public void update(Object o) {
    }
}

class SessionFactory {
    public Session getCurrentSession() {
        return new Session();
    }
}

public class CustomerMerger {
    private SessionFactory sessionFactory = new SessionFactory();

    @Transactional
    public void mergeCustomers(Customer custA, Customer custB) {
        // Transfer addresses from custB to custA
        for (Address address : new ArrayList<>(custB.getAddresses())) { // Use new list to avoid concurrent modification issues
            address.setCustomer(custA); // Set the new owner of the address
            custA.addAddress(address);  // Technically not needed if address is bidirectional and references are correct
        }
        custB.setDisabled(true);

        sessionFactory.getCurrentSession().update(custA);
        sessionFactory.getCurrentSession().update(custB);
    }

    public static void main(String[] args) {
    }
}