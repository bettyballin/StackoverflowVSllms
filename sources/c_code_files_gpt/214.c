#include <stdint.h>
#include <stddef.h>
#include <stdio.h> // For printf

uint16_t ip_checksum(const uint8_t *data, size_t length) {
    uint32_t sum = 0;
    for (size_t i = 0; i < length; i += 2) {
        uint16_t word = (data[i] << 8) + (i + 1 < length ? data[i + 1] : 0);
        sum += word;
        if (sum > 0xFFFF) {
            sum -= 0xFFFF;
        }
    }
    return ~sum;
}

int main() {
    uint8_t data[] = {0x01, 0x02, 0x03, 0x04, 0x05}; // Example data
    size_t length = sizeof(data) / sizeof(data[0]);
    uint16_t checksum = ip_checksum(data, length);
    printf("Checksum: 0x%04X\n", checksum);
    return 0;
}