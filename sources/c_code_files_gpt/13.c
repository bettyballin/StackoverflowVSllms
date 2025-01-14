#include <arm_neon.h>
#include <stdio.h>

void add_arrays(double *a, double *b, double *result, int n) {
    for (int i = 0; i < n; i += 2) {
        float64x2_t va = vld1q_f64(&a[i]);
        float64x2_t vb = vld1q_f64(&b[i]);
        float64x2_t vresult = vaddq_f64(va, vb);
        vst1q_f64(&result[i], vresult);
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