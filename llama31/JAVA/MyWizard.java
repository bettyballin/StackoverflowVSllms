// Define a basic Wizard class if it doesn't exist
class Wizard {
    public boolean canFlipToPreviousPage() {
        return true; // Default implementation
    }
}

public class MyWizard extends Wizard {
    @Override
    public boolean canFlipToPreviousPage() {
        // Return false to disable the back button
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        MyWizard myWizard = new MyWizard();
        System.out.println("Can flip to previous page: " + myWizard.canFlipToPreviousPage());
    }
}