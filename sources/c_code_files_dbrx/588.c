#include <stdio.h>
#include <stdint.h>

// Define hrtime_t type if it's not already defined
typedef int64_t hrtime_t;

// Define the macro
#define DIV_BY_1000000(x) ((hrtime_t)((x) >> 20))

int main() {
    uint64_t value = 1234567890123456; // example value
    hrtime_t result = DIV_BY_1000000(value);
    printf("Result: %lld\n", result);
    return 0;
}