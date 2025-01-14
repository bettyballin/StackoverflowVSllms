#include <stdint.h> // For uint32_t, uint8_t, uint16_t
#include <stdio.h>  // For printf

struct pseudo_header {
    uint32_t source_address;
    uint32_t dest_address;
    uint8_t placeholder;
    uint8_t protocol;
    uint16_t udp_length;
};

int main() {
    // Create an instance of the pseudo_header struct
    struct pseudo_header header;

    // Assign some values to the members of the struct
    header.source_address = 0x12345678; // Example source address
    header.dest_address = 0x87654321;   // Example destination address
    header.placeholder = 0;              // Placeholder value
    header.protocol = 17;                // Protocol number for UDP
    header.udp_length = 0x1234;          // Example UDP length

    // Print the values to verify
    printf("Source Address: 0x%x\n", header.source_address);
    printf("Destination Address: 0x%x\n", header.dest_address);
    printf("Placeholder: %u\n", header.placeholder);
    printf("Protocol: %u\n", header.protocol);
    printf("UDP Length: 0x%x\n", header.udp_length);

    return 0;
}