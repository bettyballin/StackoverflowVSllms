import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

public class HelloWorldMIDlet extends MIDlet implements CommandListener {
    private Display display;
    private Form form;

    public HelloWorldMIDlet() {
        // Empty constructor, required for MIDlet
    }

    public void startApp() {
        display = Display.getDisplay(this);
        form = new Form("Hello, World!");
        StringItem label = new StringItem("Hello, World!", "");
        form.append(label);
        display.setCurrent(form);
    }

    public void pauseApp() {
        // Pause functionality, required for MIDlet
    }

    public void destroyApp(boolean unconditional) {
        // Destroy functionality, required for MIDlet
    }

    public void commandAction(Command c, Displayable d) {
        // Handle command actions here
    }

    public static void main(String[] args) {
        // Not used in MIDlet execution, but included to satisfy Java compiler
    }
}