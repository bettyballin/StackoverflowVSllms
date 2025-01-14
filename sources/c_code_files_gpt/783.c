#include <stdio.h>
#include <stdint.h>
#include <stddef.h>

// Placeholder function definitions - you need to implement these
void serialize_insert(uint8_t, uint8_t, const char*, uint8_t*, size_t*);
void deserialize(uint8_t*, size_t);
void serialize_delete(uint8_t, uint8_t, uint8_t*, size_t*);

int main() {
    uint8_t buffer[256];
    size_t length;

    // Serialize an INSERT command
    serialize_insert(1, 108, "chille", buffer, &length);
    printf("Serialized INSERT: ");
    for (size_t i = 0; i < length; i++) {
        printf("%02x ", buffer[i]);
    }
    printf("\n");

    // Deserialize the INSERT command
    deserialize(buffer, length);

    // Serialize a DELETE command
    serialize_delete(2, 1, buffer, &length);
    printf("Serialized DELETE: ");
    for (size_t i = 0; i < length; i++) {
        printf("%02x ", buffer[i]);
    }
    printf("\n");

    // Deserialize the DELETE command
    deserialize(buffer, length);

    return 0;
}