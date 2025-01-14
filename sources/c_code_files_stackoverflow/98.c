#include <stdio.h>

unsigned short crc16_update(unsigned short crc, unsigned char nextByte) {
    crc ^= nextByte;

    for (int i = 0; i < 8; ++i) {
        if (crc & 1)
            crc = (crc >> 1) ^ 0xA001;
        else
            crc = (crc >> 1);
    }

    return crc;
}

int main() {
    unsigned short crc = 0; // Initial CRC value
    unsigned char data = 'A'; // Example byte to calculate CRC for

    crc = crc16_update(crc, data);

    printf("CRC-16 for byte '%c' is: 0x%04X\n", data, crc);

    return 0;
}