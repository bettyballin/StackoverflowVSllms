public class User {
    private int permissions;
    // other member variables, setters/getters, etc.

    public void addPermission(Permission permission) {
        this.permissions |= permission.getValue();
    }
}

enum Permission {
    VIEW_USERS(1),
    EDIT_USERS(2);
    // other permissions

    private final int value;

    Permission(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}