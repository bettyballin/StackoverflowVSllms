#include <immintrin.h>
#include <stdio.h>

void add_arrays(double *a, double *b, double *result, int n) {
    for (int i = 0; i < n; i += 4) {
        __m256d va = _mm256_loadu_pd(&a[i]);
        __m256d vb = _mm256_loadu_pd(&b[i]);
        __m256d vresult = _mm256_add_pd(va, vb);
        _mm256_storeu_pd(&result[i], vresult);
    }
}

int main() {
    double a[8] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
    double b[8] = {9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0};
    double result[8];

    // Check if AVX is supported
    if (!__builtin_cpu_supports("avx")) {
        printf("AVX not supported\n");
        return -1;
    }

    add_arrays(a, b, result, 8);

    for (int i = 0; i < 8; i++) {
        printf("%f ", result[i]);
    }

    return 0;
}