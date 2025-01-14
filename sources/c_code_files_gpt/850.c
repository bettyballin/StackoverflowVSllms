#include <immintrin.h> // Include AVX intrinsics
#include <stdio.h>

void add_arrays(float* a, float* b, float* result, int size) {
    int i;
    for (i = 0; i < size; i += 8) {
        // Load 8 floats from each array
        __m256 vec_a = _mm256_loadu_ps(&a[i]);
        __m256 vec_b = _mm256_loadu_ps(&b[i]);
        // Perform vector addition
        __m256 vec_result = _mm256_add_ps(vec_a, vec_b);
        // Store the result
        _mm256_storeu_ps(&result[i], vec_result);
    }
}

int main() {
    const int size = 16; // Make sure size is a multiple of 8
    float a[size] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0};
    float b[size] = {16.0, 15.0, 14.0, 13.0, 12.0, 11.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0};
    float result[size];

    add_arrays(a, b, result, size);

    // Print the result
    for (int i = 0; i < size; i++) {
        printf("%f ", result[i]);
    }
    printf("\n");

    return 0;
}