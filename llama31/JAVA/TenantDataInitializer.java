import java.util.List;

class Tenant {
    private String name;
    private static Tenant currentTenant;

    public Tenant(String name) {
        this.name = name;
    }

    public static Tenant getCurrentTenant() {
        return currentTenant;
    }

    public static void setCurrentTenant(Tenant tenant) {
        currentTenant = tenant;
    }
}

class Customer {
    private String name;
    private Tenant tenant;

    public Customer(String name) {
        this.name = name;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public static List<Customer> findAllByTenant(Tenant tenant) {
        // This method should be implemented based on your actual data storage and retrieval mechanism
        // For demonstration purposes, it returns an empty list
        return List.of();
    }
}

public class TenantDataInitializer {
    public static void main(String[] args) {
        // Create a separate tenant for demo data
        Tenant demoTenant = new Tenant("demo");
        Tenant.setCurrentTenant(demoTenant);

        // Create demo data in the demo tenant
        Customer demoCustomer = new Customer("Demo Customer");
        demoCustomer.setTenant(demoTenant);

        // Filter out demo data in your queries
        List<Customer> customers = Customer.findAllByTenant(Tenant.getCurrentTenant());
    }
}