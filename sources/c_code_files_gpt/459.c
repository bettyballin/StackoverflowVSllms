#include <stdio.h>

// Base address for LPT1 (can vary)
#define LPT1_BASE 0x378

// Control registers offsets (example for LPT1)
#define DATA_PORT LPT1_BASE
#define STATUS_PORT (LPT1_BASE + 1)
#define CONTROL_PORT (LPT1_BASE + 2)

void setup_epp_mode() {
    // Set the control port to EPP mode
    asm volatile("outb %%al, %%dx" : : "a" (0x04), "d" (CONTROL_PORT));
}

void write_data(unsigned char data) {
    asm volatile("outb %%al, %%dx" : : "a" (data), "d" (DATA_PORT));
}

unsigned char read_data() {
    unsigned char data;
    asm volatile("inb %%dx, %%al" : "=a" (data) : "d" (DATA_PORT));
    return data;
}

int main() {
    setup_epp_mode();

    // Write data to the parallel port
    write_data(0xAA); // Example data

    // Read data from the parallel port
    unsigned char received_data = read_data();
    printf("Received data: %02X\n", received_data);

    return 0;
}