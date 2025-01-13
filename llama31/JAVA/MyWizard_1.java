import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.IWizardPage;

public class MyWizard_1_1 extends Wizard {
    //...

    @Override
    public IWizardPage getPreviousPage(IWizardPage currentPage) {
        // Return null to disable the back button
        return null;
    }

    public static void main(String[] args) {
    }
}