import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.ui.preferences.IWorkbenchPreferencePage;

public class ShowHiddenFiles {
    public static void main(String[] args) {
        // Adjusted code to make it executable with javac
        PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(null, "org.eclipse.ui.prefpages.WorkspaceResource", null, null);
        if (dialog != null) {
            dialog.create(); // Ensure the dialog and pages are created
            IPreferenceNode node = dialog.getPreferenceManager().find("org.eclipse.ui.prefpages.WorkspaceResource");
            if (node != null && node.getPage() instanceof IWorkbenchPreferencePage) {
                ((IWorkbenchPreferencePage) node.getPage()).init(PlatformUI.getWorkbench());
                // Access the filter preference directly or programmatically uncheck it
                // This part would require knowledge of internal APIs and is not recommended for production use.
            }
        }
    }
}