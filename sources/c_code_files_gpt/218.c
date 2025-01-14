#include <stdint.h>
#include <stdio.h>

// CRC-16-CCITT polynomial: x^16 + x^12 + x^5 + 1 (0x1021)
#define CRC16_POLY 0x1021

uint16_t crc16(const uint8_t *data, size_t length) {
    uint16_t crc = 0xFFFF;  // Initial value
    for (size_t i = 0; i < length; i++) {
        crc ^= (uint16_t)data[i] << 8;
        for (uint8_t j = 0; j < 8; j++) {
            if (crc & 0x8000) {
                crc = (crc << 1) ^ CRC16_POLY;
            } else {
                crc <<= 1;
            }
        }
    }
    return crc;
}

int main() {
    uint8_t data[] = "Hello, World!";
    size_t length = sizeof(data) - 1; // Exclude the null terminator
    uint16_t crc = crc16(data, length);
    printf("CRC-16 of '%s' is: 0x%04X\n", data, crc);
    return 0;
}