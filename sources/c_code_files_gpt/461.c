#include <stdint.h>
#include <stdio.h>

// 8-bit integers
int8_t myInt8;
uint8_t myUInt8;

// 16-bit integers
int16_t myInt16;
uint16_t myUInt16;

// 32-bit integers
int32_t myInt32;
uint32_t myUInt32;

// 64-bit integers
int64_t myInt64;
uint64_t myUInt64;

int main() {
    // Initialize variables
    myInt8 = -10;
    myUInt8 = 10;
    myInt16 = -100;
    myUInt16 = 100;
    myInt32 = -1000;
    myUInt32 = 1000;
    myInt64 = -10000;
    myUInt64 = 10000;

    // Print the values
    printf("myInt8: %d\n", myInt8);
    printf("myUInt8: %u\n", myUInt8);
    printf("myInt16: %d\n", myInt16);
    printf("myUInt16: %u\n", myUInt16);
    printf("myInt32: %d\n", myInt32);
    printf("myUInt32: %u\n", myUInt32);
    printf("myInt64: %lld\n", myInt64);
    printf("myUInt64: %llu\n", myUInt64);

    return 0;
}