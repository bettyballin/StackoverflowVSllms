import java.lang.String;

public class MyWizardPage extends WizardPage {
    private boolean allowBack = true;

    public MyWizardPage(String pageName) {
        super(pageName);
    }

    @Override
    public IWizardPage getPreviousPage() {
        return allowBack ? super.getPreviousPage() : null;
    }

    @Override
    public boolean canFlipToPreviousPage() {
        // Control the back button's availability here
        return allowBack;
    }

    public void disableBackButton() {
        this.allowBack = false;
    }

    public static void main(String[] args) {
        // Example usage
        MyWizardPage page = new MyWizardPage("My Page");
        page.disableBackButton();
        System.out.println("Can flip to previous page: " + page.canFlipToPreviousPage());
    }
}

class WizardPage implements IWizardPage {
    private String pageName;

    public WizardPage(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public IWizardPage getPreviousPage() {
        // Return a dummy previous page or null
        return null;
    }

    @Override
    public boolean canFlipToPreviousPage() {
        // Default implementation
        return true;
    }
}

interface IWizardPage {
    IWizardPage getPreviousPage();
    boolean canFlipToPreviousPage();
}