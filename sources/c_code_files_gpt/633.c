#include <immintrin.h>
#include <stdio.h>

void vectorized_add_hand(float *a, float *b, float *c, int n) {
    int i;
    for (i = 0; i <= n - 8; i += 8) {
        __m256 vec_a = _mm256_loadu_ps(&a[i]);
        __m256 vec_b = _mm256_loadu_ps(&b[i]);
        __m256 vec_c = _mm256_add_ps(vec_a, vec_b);
        _mm256_storeu_ps(&c[i], vec_c);
    }
    for (; i < n; i++) {
        c[i] = a[i] + b[i];
    }
}

int main() {
    const int n = 16;
    float a[n] = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f};
    float b[n] = {16.0f, 15.0f, 14.0f, 13.0f, 12.0f, 11.0f, 10.0f, 9.0f, 8.0f, 7.0f, 6.0f, 5.0f, 4.0f, 3.0f, 2.0f, 1.0f};
    float c[n];

    vectorized_add_hand(a, b, c, n);

    printf("Result:\n");
    for (int i = 0; i < n; i++) {
        printf("%f ", c[i]);
    }
    printf("\n");

    return 0;
}