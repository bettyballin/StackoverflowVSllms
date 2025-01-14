import java.lang.String;
import org.usb4java.*;

public class UsbDeviceLister {
    public static void main(String[] args) throws LibUsbException {
        // Initialize the library. You MUST do this before calling any libusb functions.
        int result = LibUsb.init(null);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to initialize libusb", result);
        }

        // Read the USB device list
        DeviceList list = new DeviceList();
        result = LibUsb.getDeviceList(null, list);
        if (result < 0) {
            throw new LibUsbException("Unable to get device list", result);
        }

        try {
            // Iterate over all devices and dump them to stdout.
            for (Device device : list) {
                DeviceDescriptor descriptor = new DeviceDescriptor();
                result = LibUsb.getDeviceDescriptor(device, descriptor);
                if (result != LibUsb.SUCCESS) {
                    throw new LibUsbException("Unable to read device descriptor", result);
                }

                System.out.format("\nBus %03d Device %03d: ID %04x:%04x\n",
                        LibUsb.getBusNumber(device),
                        LibUsb.getDeviceAddress(device),
                        (int) descriptor.idVendor(), (int) descriptor.idProduct());
            }
        } finally {
            // Ensure the allocated device list is freed.
            LibUsb.freeDeviceList(list, true);
        }

        // Deinitialize the library. You MUST do this after you are done with libusb.
        LibUsb.exit(null);
    }
}