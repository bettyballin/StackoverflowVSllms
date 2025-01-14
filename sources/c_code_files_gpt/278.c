#include "usb_library.h" // Include your MCU's USB library

int main(void) { // Change return type to int
    usb_init(); // Initialize USB
    while (1) {
        usb_poll(); // Poll USB events

        if (usb_data_received()) {
            uint8_t data = usb_read(); // Read data from host
            handle_data(data); // Handle received data
        }

        if (button_pressed()) {
            uint8_t report = generate_report(); // Generate report for button press
            usb_send(report); // Send report to host
        }
    }
    return 0; // Add return statement
}