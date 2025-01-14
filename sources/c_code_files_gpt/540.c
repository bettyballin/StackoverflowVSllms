#include <xmmintrin.h>
#include <stdio.h>

int main() {
    // Align the arrays on 16-byte boundaries
    float a[4] __attribute__((aligned(16))) = { 10, 20, 30, 40 };
    float b[4] __attribute__((aligned(16))) = { 0.1, 0.1, 0.1, 0.1 };

    asm volatile(
        "movaps (%0), %%xmm0\n\t"  // Load a into xmm0
        "movaps (%1), %%xmm1\n\t"  // Load b into xmm1
        "mulps %%xmm1, %%xmm0\n\t" // Multiply xmm0 and xmm1
        "movaps %%xmm0, (%1)"      // Store result back to b
        :: "r" (a), "r" (b)
        : "xmm0", "xmm1"
    );

    // Printing the result for verification
    for (int i = 0; i < 4; ++i) {
        printf("%f ", b[i]);
    }

    return 0;
}