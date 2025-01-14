#include <immintrin.h>

void addVectors(float *a, float *b) {
    __asm__ volatile(
        "vmovaps %1, %%xmm0;"  // Load b into xmm0
        "vaddps %2, %%xmm0, %%xmm0;"  // Add a to xmm0
        "vmovaps %%xmm0, %0;"  // Store result in a
        : "=m" (*a)            // Output operand
        : "m" (*b), "m" (*a)   // Input operands
        : "xmm0"               // Clobbered register
    );
}

int main() {
    float a = 5.0;
    float b = 3.0;
    addVectors(&a, &b);
    // Note: The result is stored in 'a'
    return 0;
}