#include <stdint.h>

uint64_t combine_integers(int64_t x, uint32_t y) {
    uint64_t z = ((int64_t)x << 32) | (y & 0xFFFFFFFF);
    return z;
}

int main() {
    int64_t x = 1;
    uint32_t y = 2;
    uint64_t result = combine_integers(x, y);
    // You can print or use the result here
    return 0;
}