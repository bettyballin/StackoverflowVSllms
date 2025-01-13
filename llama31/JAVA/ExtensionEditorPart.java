import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormEditor;
import org.eclipse.ui.forms.FormPage;
import org.eclipse.ui.forms.FormToolkit;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.Section;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.swt.SWT;

public class ExtensionEditorPart extends FormPage {

    public ExtensionEditorPart(FormEditor editor) {
        super(editor, "extensionEditor", "Extension Editor");
    }

    private void createFormContent() {
        FormToolkit toolkit = getFormToolkit();
        Section section = toolkit.createSection(getClient(), Section.DESCRIPTION | Section.TITLE_BAR);
        section.setText("Extension Editor");

        Composite composite = toolkit.createComposite(section, SWT.WRAP);
        composite.setLayout(new GridLayout(2, false));

        // Create the extension point ID field
        Label label = toolkit.createLabel(composite, "Extension Point ID:");
        label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        Text text = toolkit.createText(composite, "");
        text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        // Create the extension point name field
        label = toolkit.createLabel(composite, "Extension Point Name:");
        label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
        text = toolkit.createText(composite, "");
        text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    }

    public static void main(String[] args) {
        // Create a new Display
        Display display = new Display();

        // Create a new Shell
        Shell shell = new Shell(display);

        // Create a new FormEditor
        FormEditor editor = new FormEditor();

        // Create a new ExtensionEditorPart
        ExtensionEditorPart part = new ExtensionEditorPart(editor);

        // Call the createFormContent method
        part.createFormContent();

        // Open the Shell
        shell.open();

        // Main loop
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }

        // Dispose the Display
        display.dispose();
    }
}