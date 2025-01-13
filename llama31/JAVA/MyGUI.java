// Define the Role enum
enum Role {
    ADMIN, USER
}

// Define the PrintAction class
class PrintAction {
    public boolean isAuthorized(Role role) {
        // For demonstration purposes, only ADMIN role is authorized
        return role == Role.ADMIN;
    }

    public void execute() {
        System.out.println("Print button clicked");
    }
}

public class MyGUI {
    private Role currentUserRole;

    public MyGUI(Role currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    public void printButtonClicked() {
        PrintAction action = new PrintAction();
        if (action.isAuthorized(currentUserRole)) {
            action.execute();
        } else {
            System.out.println("Unauthorized access");
        }
    }

    public static void main(String[] args) {
        MyGUI myGUI = new MyGUI(Role.ADMIN);
        myGUI.printButtonClicked();
    }
}