#include <emmintrin.h>
#include <stdio.h>

void add_arrays(double *a, double *b, double *result, int n) {
    for (int i = 0; i < n; i += 2) {
        __m128d va = _mm_loadu_pd(&a[i]);
        __m128d vb = _mm_loadu_pd(&b[i]);
        __m128d vresult = _mm_add_pd(va, vb);
        _mm_storeu_pd(&result[i], vresult);
    }
}

int main() {
    double a[4] = {1.0, 2.0, 3.0, 4.0};
    double b[4] = {5.0, 6.0, 7.0, 8.0};
    double result[4];
    
    add_arrays(a, b, result, 4);

    for (int i = 0; i < 4; i++) {
        printf("%f ", result[i]);
    }

    return 0;
}