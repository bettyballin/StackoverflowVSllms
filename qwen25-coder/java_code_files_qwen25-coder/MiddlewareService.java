public class BusinessLogicService {
    public CustomerData fetchCustomerData(int customerId, int additionalParameter) {
        // Core business logic: validate user permissions, calculate eligibility etc.
        // ...
        return new CustomerData(); 
    }

    private CustomerData lookupInDatabaseOrCache(int customerId) {
        // Implementation for fetching business data
        return new CustomerData();
    }

    public static void main(String[] args) {
        // Instantiate the services
        BusinessLogicService businessLogicService = new BusinessLogicService();
        MiddlewareService middlewareService = new MiddlewareService(businessLogicService);
        
        // Retrieve customer data
        CustomerData data = middlewareService.retrieveCustomerData(123);
        // You can add code here to utilize 'data' as needed
    }
}

class MiddlewareService {
    private final BusinessLogicService businessLogicService;

    public MiddlewareService(BusinessLogicService businessLogicService) {
        this.businessLogicService = businessLogicService;
    }

    public CustomerData retrieveCustomerData(int customerId) {
        // Preprocessing or additional parameter fetching can occur here.
        int additionalParameter = getAdditionalParameter(customerId);
        
        // Delegates to business logic
        return businessLogicService.fetchCustomerData(customerId, additionalParameter);
    }

    private int getAdditionalParameter(int customerId) {
        // Light processing to determine an additional parameter needed by business logic
        return lookupInDatabaseOrCache(customerId);
    }

    private int lookupInDatabaseOrCache(int customerId) {
        // Implementation for fetching the additional parameter data
        return 42; // Placeholder value
    }
}

class CustomerData {
    // Fields and methods for customer data
    // This is a placeholder class to allow the code to compile
}