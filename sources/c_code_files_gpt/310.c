#include <emmintrin.h>

void process(float *a, float *b, float *c) {
    __m128 va = _mm_load_ps(a);
    __m128 vb = _mm_load_ps(b);
    __m128 vc = _mm_add_ps(va, vb);
    _mm_store_ps(c, vc);
}

int main() {
    float a[] = {1.0, 2.0, 3.0, 4.0};
    float b[] = {5.0, 6.0, 7.0, 8.0};
    float c[4];

    process(a, b, c);

    // Print the result
    for (int i = 0; i < 4; i++) {
        printf("%f ", c[i]);
    }
    printf("\n");

    return 0;
}