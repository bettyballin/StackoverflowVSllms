// Base Wizard class
class Wizard {
    public boolean canFlipToNextPage() {
        // Default implementation
        return true;
    }

    public Container getContainer() {
        return new Container();
    }

    public IWizardPage getPage(int index) {
        if (index == 1) {
            return new MySecondWizardPage();
        } else {
            return new SomeOtherWizardPage();
        }
    }
}

// Container class with getCurrentPage method
class Container {
    public int getCurrentPage() {
        return 0; // For simplicity, returning 0
    }
}

// IWizardPage interface
interface IWizardPage {
    // Define any necessary methods (empty for this example)
}

// MySecondWizardPage class implementing IWizardPage
class MySecondWizardPage implements IWizardPage {
    // Implementation details (empty for this example)
}

// SomeOtherWizardPage class implementing IWizardPage
class SomeOtherWizardPage implements IWizardPage {
    // Implementation details (empty for this example)
}

public class MyWizard extends Wizard {

    @Override
    public boolean canFlipToNextPage() {
        // Check which page is currently active and return true if it should allow going to next page or false otherwise.
        int currentIndex = getContainer().getCurrentPage();
        IWizardPage nextPage = getPage(currentIndex + 1);
        if (nextPage instanceof MySecondWizardPage) {
            // Returning false will disable the back button on this specific page.
            return false;
        } else {
            // Leave other pages as they are by calling super method.
            return super.canFlipToNextPage();
        }
    }
}