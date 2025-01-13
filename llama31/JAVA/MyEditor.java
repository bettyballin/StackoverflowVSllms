import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.jst.pagedesigner.ui.WebPageEditor;

public class MyEditor extends EditorPart {

    @Override
    public void createPartControl(Composite parent) {
        WebPageEditor editor = new WebPageEditor();
        editor.createPartControl(parent);
    }

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("MyEditor");
        shell.setSize(800, 600);

        MyEditor editor = new MyEditor();
        editor.createPartControl(shell);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}