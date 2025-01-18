import java.util.Map;
import java.lang.String;
public class CustomerMapper_1 {
    private CustomerDAO customerDAO = new CustomerDAO();

    public CustomerDTO getCustomer(int id) {
        Customer customer = customerDAO.getCustomerById(id); // Fetch your Hibernate entity

        // Map fields from Hibernate entities to DTOs before transmission.
        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());

        return dto;
    }
    public static void main(String[] args) {
    }
}
class Customer {
    public String getName() {
        return "Customer Name";
    }
}

class CustomerDAO {
    public Customer getCustomerById(int id) {
        return new Customer();
    }
}

class CustomerDTO {
    public void setName(String name) {
    }
}