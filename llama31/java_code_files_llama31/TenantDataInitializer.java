/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class TenantDataInitializer {
    public static void main(String[] stringArray) {
        Tenant tenant = new Tenant("demo");
        Tenant.setCurrentTenant(tenant);
        Customer customer = new Customer("Demo Customer");
        customer.setTenant(tenant);
        List<Customer> list = Customer.findAllByTenant(Tenant.getCurrentTenant());
    }
}
