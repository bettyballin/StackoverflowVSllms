import java.lang.String;
import javax.inject.Inject;

// Middleware component that fetches the "other parameter"
public class ParameterFetcher {
    @Inject
    private CustomerDataService customerDataService;

    public String fetchOtherParameter(String customerId) {
        // Implement logic to fetch the other parameter
        // using the customerDataService
        return customerDataService.getOtherParameter(customerId);
    }

    public static void main(String[] args) {
        // Create an instance of ParameterFetcher
        ParameterFetcher fetcher = new ParameterFetcher();

        // Create a mock CustomerDataService for demonstration purposes
        fetcher.customerDataService = new CustomerDataService() {
            @Override
            public String getOtherParameter(String customerId) {
                // Mock implementation
                return "Other parameter for customer " + customerId;
            }
        };

        // Test the fetchOtherParameter method
        String customerId = "123";
        String otherParameter = fetcher.fetchOtherParameter(customerId);
        System.out.println("Other parameter: " + otherParameter);
    }
}

// Mock interface for CustomerDataService
interface CustomerDataService {
    String getOtherParameter(String customerId);
}