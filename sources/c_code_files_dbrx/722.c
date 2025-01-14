#include <limits.h> // For UINT16_MAX and UINT32_MAX

// Unsigned saturating addition (16 bit)
#define SATURATE16(x, y) ({ \
    uint16_t sum = ((uint16_t)(x) + (y)); \
    (sum < (uint16_t)(x) || sum < (uint16_t)(y)) ? UINT16_MAX : sum; })

// Unsigned saturating addition (32 bit)
#define SATURATE32(x, y) ({ \
    uint32_t sum = ((uint32_t)(x) + (y)); \
    (sum < (uint32_t)(x) || sum < (uint32_t)(y)) ? UINT32_MAX : sum; })

int main() {
    uint16_t x16 = 65530;
    uint16_t y16 = 10;
    uint16_t result16 = SATURATE16(x16, y16);
    printf("Saturated addition (16 bit): %d + %d = %d\n", x16, y16, result16);

    uint32_t x32 = 4294967290;
    uint32_t y32 = 10;
    uint32_t result32 = SATURATE32(x32, y32);
    printf("Saturated addition (32 bit): %d + %d = %d\n", x32, y32, result32);

    return 0;
}