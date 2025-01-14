#include <stdio.h>
#include <stdint.h>

// Simulating the outp function since it's not standard C.
// This example assumes you're working on a platform where direct port access is possible.
// For most modern operating systems, this would require writing a kernel driver.
void outp(uint16_t port, uint8_t value) {
    // This is a simulation. Actual implementation depends on your target platform.
    printf("Writing value 0x%x to port 0x%x\n", value, port);
    // Actual port writing logic would go here, specific to your platform.
}

#define PORT_ADDRESS 0x378

int main() {
    // Replace 0x02 with the desired data. Here, 0x02 corresponds to binary 00000010.
    uint8_t send_data = 0x02; // Example data

    outp(PORT_ADDRESS, send_data);

    return 0;
}