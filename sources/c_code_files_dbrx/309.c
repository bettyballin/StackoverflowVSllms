#include <stdint.h>

#pragma pack(push)
#pragma pack(1)
typedef struct {
    uint32_t day   : 5; // occupies 5 bits
    uint32_t hour  : 6; // occupies 6 bits
    uint32_t minute: 6; // occupies 6 bits
} MinimalTs;
#pragma pack(pop)

int main() {
    MinimalTs ts;
    ts.day = 1;
    ts.hour = 12;
    ts.minute = 30;
    return 0;
}