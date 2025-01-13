import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class EditorContributionTest {
    @Test
    public void testEditorContribution() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IEditorRegistry registry = workbench.getEditorRegistry();
        IEditorDescriptor[] editors = registry.getEditors("myeditorid");
        assertNotNull(editors);
        assertEquals(1, editors.length);
        assertEquals("My Editor", editors[0].getLabel());
    }
    public static void main(String[] args) {
    }
}