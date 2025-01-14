import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class DisplayInfo extends Canvas {
    // Declare native method
    static {
        System.loadLibrary("xinfo");
    }
    
    // Native method declaration
    public native String getScreenDimensions();
    
    public void printScreenInfo() {
        System.out.println(getScreenDimensions());
    }
    
    public DisplayInfo(Composite parent, int style) {
        super(parent, style);
    }
    
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        
        // Create an instance of the class containing the native method
        DisplayInfo info = new DisplayInfo(shell, 0); // Provide shell as parent and style
        info.printScreenInfo(); // This should print the dimensions
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}