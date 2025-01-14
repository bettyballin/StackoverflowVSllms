#include <stdint.h>
#include <stdio.h>

typedef struct {
    uint16_t minute: 6; // 6 bits for minute
    uint16_t hour: 5;   // 5 bits for hour
    uint16_t day: 5;    // 5 bits for day
} Timestamp;

int main() {
    Timestamp timestamp;
    timestamp.minute = 0;
    timestamp.hour = 0;
    timestamp.day = 0;
    printf("Size of Timestamp: %zu bytes\n", sizeof(Timestamp));
    return 0;
}