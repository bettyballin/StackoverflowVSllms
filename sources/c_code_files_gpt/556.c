#include <stdint.h>
#include <stdio.h>

// Function to compute CRC32
uint32_t crc32(const void *data, size_t n_bytes) {
    uint32_t crc = 0xFFFFFFFF;
    static uint32_t table[256];
    static int have_table = 0;

    if (!have_table) {
        for (uint32_t i = 0; i < 256; i++) {
            uint32_t c = i;
            for (int j = 0; j < 8; j++) {
                if (c & 1) {
                    c = 0xEDB88320L ^ (c >> 1);
                } else {
                    c = c >> 1;
                }
            }
            table[i] = c;
        }
        have_table = 1;
    }

    for (size_t i = 0; i < n_bytes; i++) {
        uint8_t byte = ((uint8_t *)data)[i];
        crc = table[(crc ^ byte) & 0xFF] ^ (crc >> 8);
    }

    return crc ^ 0xFFFFFFFF;
}

int main() {
    const char* data = "Hello, World!";
    uint32_t crc = crc32(data, strlen(data));
    printf("CRC32 of '%s' is 0x%08X\n", data, crc);
    return 0;
}