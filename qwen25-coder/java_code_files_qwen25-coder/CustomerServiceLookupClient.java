import java.util.List;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerServiceLookupClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            CustomerService customerService = (CustomerService) registry.lookup("CustomerService");
            List<CustomerDTO> customersWithArticles = customerService.getCustomersWithArticles();
            // Process customersWithArticles...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}