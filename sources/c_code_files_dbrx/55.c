#include <stdio.h>

int main() {
    float a_aligned[4] __attribute__ ((aligned (16))) = { 10, 20, 30, 40 };
    float b_aligned[4] __attribute__ ((aligned (16))) = { 0.1, 0.1, 0.1, 0.1 };
    asm volatile("vmovaps (%0), %%ymm0\n\t"    // assuming AVX support available; use vmulps instead of mulps for performance gain if possible
                 "vmulps  (%1), %%ymm0, %%ymm0\n\t"
              :: "r" (a_aligned), "r" (b_aligned));
    return 0;
}