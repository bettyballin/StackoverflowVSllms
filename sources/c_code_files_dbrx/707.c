#include <stdio.h>
#include <libusb.h>

// Device information:
static const char *DEV_VENDOR = "Your Vendor"; // Replace with your vendor name.
static const char *DEV_PRODUCT = "Your Product"; // Replace with your product name.
static const int DEV_VID = 0x1234; // Replace with your own Vendor ID (get from USB-IF)
static const int DEV_PID = 0x5678; //Replace with your own Product ID

int main(void) {
    libusb_device **list;
    ssize_t devices_found = libusb_get_device_list(NULL, &list);

    // Loop through the list of USB devices and find yours:
    for (size_t i = 0; i < devices_found; ++i) {
        libusb_device *device = list[i];

        struct libusb_device_descriptor desc;
        int ret = libusb_get_device_descriptor(device, &desc);
        if (ret < 0) break;

        // Check device's VID and PID to see if it matches yours:
        if ((desc.idVendor == DEV_VID || !DEV_VENDOR) && 
            (desc.idProduct == DEV_PID || !DEV_PRODUCT)) {
            /*Your code here, do data transfer or handle events*/
        }
    }
    libusb_free_device_list(list, 1); // Free the device list
    return 0;
}