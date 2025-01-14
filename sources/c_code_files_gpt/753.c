#include <stdio.h>
#include <stdint.h>
#include <string.h>

// Define the INSERT and DELETE commands
#define INSERT 1
#define DELETE 2

void deserialize(const uint8_t* buffer, size_t length) {
    uint8_t command = buffer[0];
    uint8_t table_id = buffer[1];

    if (command == INSERT) {
        uint8_t temperature = buffer[2];
        uint8_t loc_len = buffer[3];
        char location[256];
        memcpy(location, &buffer[4], loc_len);
        location[loc_len] = '\0';
        
        printf("INSERT INTO table %d (temperature, location) VALUES (%d, '%s')\n", table_id, temperature, location);
    } else if (command == DELETE) {
        uint8_t id = buffer[2];
        
        printf("DELETE FROM table %d WHERE id=%d\n", table_id, id);
    } else {
        printf("Unknown command\n");
    }
}

int main() {
    uint8_t buffer[] = {INSERT, 1, 25, 5, 'H', 'e', 'l', 'l', 'o'};
    deserialize(buffer, sizeof(buffer));
    return 0;
}