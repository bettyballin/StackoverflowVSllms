/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

class Customer {
    private String name;
    private Tenant tenant;

    public Customer(String string) {
        this.name = string;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public static List<Customer> findAllByTenant(Tenant tenant) {
        return List.of();
    }
}
