#include <stdint.h>

#if __ARM_ARCH__ >= 6
// FTOSI instruction is available for ARMv6 and above
uint32_t ftosi(float value) {
    // Use inline assembly to generate the FTOSI instruction
    uint32_t result = 0;
    asm volatile("vld1.f32 %0, [%1] \n\t"
                 "vcvt.s32.f32 %0, %0 \n\t"
                 "vst1.s32 %0, [%2] \n\t"
                 : "=r" (result)
                 : "r" (&value), "r" (value)
                 :);
    return result;
}
#else
// FTOSI instruction not available, fallback to naive implementation
int16_t floatToInt(float value) {
    int16_t result = (int16_t)(value * 32768.0f + 0.5);
    return result;
}
#endif