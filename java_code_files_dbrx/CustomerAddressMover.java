import java.util.List;
import java.util.ArrayList;

public class CustomerAddressMover {

    private Customer customerA = new Customer();
    private Customer customerB = new Customer();

    public void moveAddresses() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Address> addresses = customerB.getAddresses(); // all the addresses of customer B first
            for (Address a : addresses) {
                customerA.addAddress(a); // add to customer A's list, it could be in both lists now
                a.setCustomer(customerA); // this step is important! need to update the child reference too!
            }
            session.update(customerB); // just disable the B customer here or whatever you want
            tx.commit();  // no matter commit before or after merge
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (RuntimeException rbe) {
                    log("Error rolling back transaction", rbe);
                }
                throw e;
            }
        } finally {
            session.flush(); // always remember to flush the session and also rollback if anything goes wrong!
            session.close();
        }
    }

    private HibernateTemplate getHibernateTemplate() {
        return new HibernateTemplate();
    }

    private void log(String message, Exception e) {
        // Logging implementation here
        System.out.println(message);
        e.printStackTrace();
    }

    public static void main(String[] args) {
        CustomerAddressMover mover = new CustomerAddressMover();
        mover.moveAddresses();
    }

    // Dummy classes to make the code executable
    class HibernateTemplate {
        public SessionFactory getSessionFactory() {
            return new SessionFactory();
        }
    }

    class SessionFactory {
        public Session openSession() {
            return new Session();
        }
    }

    class Session {
        public Transaction beginTransaction() {
            return new Transaction();
        }

        public void update(Customer customer) {
            // Update customer
        }

        public void flush() {
            // Flush the session
        }

        public void close() {
            // Close the session
        }
    }

    class Transaction {
        public void commit() {
            // Commit transaction
        }

        public void rollback() {
            // Rollback transaction
        }
    }

    class Customer {
        private List<Address> addresses = new ArrayList<Address>();

        public List<Address> getAddresses() {
            return addresses;
        }

        public void addAddress(Address address) {
            addresses.add(address);
        }
    }

    class Address {
        public void setCustomer(Customer customer) {
            // Set customer for address
        }
    }

    class HibernateException extends Exception {
        public HibernateException(String message) {
            super(message);
        }
    }
}