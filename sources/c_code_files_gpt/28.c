#include <stdio.h>
#include <stdint.h>

int main() {
    // 32-bit integer
    int32_t a = 2147483647;  // Max value for 32-bit signed integer
    // 64-bit integer
    int64_t b = 9223372036854775807;  // Max value for 64-bit signed integer

    printf("32-bit integer: %d\n", a);
    printf("64-bit integer: %lld\n", b);

    return 0;
}