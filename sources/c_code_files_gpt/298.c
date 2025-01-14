#include <stdint.h>

int16_t floatToInt16(float value) {
    int result;
    __asm__ volatile (
        "fistps %0\n\t"
        "movsx %0, %0"
        : "=r" (result)
        : "t" (value)
        : "st(0)"
    );
    return (int16_t)result;
}

int main() {
    float nextFloat = 0.5f;
    int16_t nextInt = floatToInt16(nextFloat * 32768.0f + 0.5f);
    return 0;
}