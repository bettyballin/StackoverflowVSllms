/*
 * Decompiled with CFR 0.152.
 */
class UserViewBean {
    private String name;
    private int departmentCount;

    public UserViewBean(String string, int n) {
        this.name = string;
        this.departmentCount = n;
    }

    public String getName() {
        return this.name;
    }

    public int getDepartmentCount() {
        return this.departmentCount;
    }
}
