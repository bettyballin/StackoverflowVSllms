#include <stdio.h>
#include <stdint.h>
#include <string.h>

#define INSERT 1
#define DELETE 2

void serialize_insert(int table_id, uint8_t temperature, const char* location, uint8_t* buffer, size_t* length) {
    buffer[0] = INSERT;
    buffer[1] = table_id;
    buffer[2] = temperature;
    size_t loc_len = strlen(location);
    buffer[3] = loc_len;
    memcpy(&buffer[4], location, loc_len);
    *length = 4 + loc_len;
}

void serialize_delete(int table_id, uint8_t id, uint8_t* buffer, size_t* length) {
    buffer[0] = DELETE;
    buffer[1] = table_id;
    buffer[2] = id;
    *length = 3;
}

int main() {
    // Example usage:
    uint8_t buffer[256];
    size_t length;

    int table_id = 1;
    uint8_t temperature = 25;
    const char* location = "New York";

    serialize_insert(table_id, temperature, location, buffer, &length);
    printf("Serialized insert: ");
    for (size_t i = 0; i < length; i++) {
        printf("%02x ", buffer[i]);
    }
    printf("\n");

    table_id = 1;
    uint8_t id = 123;

    serialize_delete(table_id, id, buffer, &length);
    printf("Serialized delete: ");
    for (size_t i = 0; i < length; i++) {
        printf("%02x ", buffer[i]);
    }
    printf("\n");

    return 0;
}