import java.util.List;
import java.util.ArrayList;

public class CustomerDAO_3_3 {
    public List<CustomerDTO> getCustomersWithArticles() {
        // Assuming session is a valid Hibernate session
        List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer customer : customers) {
            Hibernate.initialize(customer.getArticles());
            dtos.add(convertToDTO(customer)); // Assumes convertToDTO method
        }
        return dtos;
    }

    // Added the missing convertToDTO method for the sake of compilation
    private CustomerDTO convertToDTO(Customer customer) {
        // Implement the logic to convert Customer to CustomerDTO
        return new CustomerDTO();
    }

    public static void main(String[] args) {
    }
}

// Assuming Customer and CustomerDTO classes exist
class Customer {
    public List<Article> getArticles() {
        return new ArrayList<>();
    }
}

class CustomerDTO {
}

class Article {
}