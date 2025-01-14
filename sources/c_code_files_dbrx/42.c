#include <stdio.h>
#include <emmintrin.h> // For SSE instructions

#define size 16 // Example size, must be a multiple of 4 for SSE
#define steps 10 // Number of steps for the outer loop

int main() {
    float A[size] __attribute__((aligned(16)));
    float B[size] __attribute__((aligned(16)));
    float sum = 0.0; // Initialize sum

    // Initialize A and B arrays for demonstration
    for (int i = 0; i < size; ++i) {
        A[i] = i; // Example initialization
        B[i] = i; // Example initialization
    }

    for (int j = 0; j < steps; ++j) {
        for (int i = 0; i < size; i += 4) { // Increment by 4 for SSE
            __m128 vecA = _mm_load_ps(A + i);
            __m128 vecB = _mm_load_ps(B + i);
            sum += _mm_dp_ps(vecA, vecB, 0xFF);
        }
    }

    printf("Sum: %f\n", sum);

    return 0;
}