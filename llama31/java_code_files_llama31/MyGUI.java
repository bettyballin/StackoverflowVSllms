/*
 * Decompiled with CFR 0.152.
 */
public class MyGUI {
    private Role currentUserRole;

    public MyGUI(Role role) {
        this.currentUserRole = role;
    }

    public void printButtonClicked() {
        PrintAction printAction = new PrintAction();
        if (printAction.isAuthorized(this.currentUserRole)) {
            printAction.execute();
        } else {
            System.out.println("Unauthorized access");
        }
    }

    public static void main(String[] stringArray) {
        MyGUI myGUI = new MyGUI(Role.ADMIN);
        myGUI.printButtonClicked();
    }
}
