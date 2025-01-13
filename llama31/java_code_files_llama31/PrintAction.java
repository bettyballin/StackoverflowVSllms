/*
 * Decompiled with CFR 0.152.
 */
class PrintAction {
    PrintAction() {
    }

    public boolean isAuthorized(Role role) {
        return role == Role.ADMIN;
    }

    public void execute() {
        System.out.println("Print button clicked");
    }
}
