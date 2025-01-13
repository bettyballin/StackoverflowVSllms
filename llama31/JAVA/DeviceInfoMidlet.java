import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

public class DeviceInfoMidlet extends MIDlet {

    public void startApp() {
        Display display = Display.getDisplay(this);
        Form form = new Form("Device Info");
        StringItem imeiItem = new StringItem("IMEI: ", "Not Available");
        form.append(imeiItem);
        display.setCurrent(form);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public static void main(String[] args) {
        // Create an instance of the MIDlet and start it.
        // Note: This is not the typical way to start a MIDlet, as it's usually
        // done by the device's application management system.
        DeviceInfoMidlet midlet = new DeviceInfoMidlet();
        try {
            midlet.startApp();
        } catch (MIDletStateChangeException e) {
            System.out.println("Error starting MIDlet: " + e.getMessage());
        }
    }
}