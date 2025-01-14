import java.util.List;
import java.util.ArrayList;

public class CustomerGateway {
    public List<Customer> GetAll() {
        // SQL: SELECT * FROM Customer
        return new ArrayList<Customer>();
    }
    // Other methods for CRUD operations

    public static void main(String[] args) {
    }
}

class Customer {
    // Customer fields and methods
}