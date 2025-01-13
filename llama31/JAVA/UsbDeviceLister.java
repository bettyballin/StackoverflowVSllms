import javax.usb.*;

public class UsbDeviceLister {
    public static void main(String[] args) {
        // Get a list of available USB devices
        UsbHub hub = UsbHostManager.getUsbServices().getRootUsbHub();
        // The following line was added to make the code executable
        System.out.println(hub);
    }
}