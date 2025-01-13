/*
 * Decompiled with CFR 0.152.
 */
class Tenant {
    private String name;
    private static Tenant currentTenant;

    public Tenant(String string) {
        this.name = string;
    }

    public static Tenant getCurrentTenant() {
        return currentTenant;
    }

    public static void setCurrentTenant(Tenant tenant) {
        currentTenant = tenant;
    }
}
