#include <stdio.h>
#include <simde/x86/sse2.h>

int main() {
    simde__m128d a = simde_mm_set_pd(1.0, 2.0);
    simde__m128d b = simde_mm_set_pd(3.0, 4.0);
    simde__m128d c = simde_mm_add_pd(a, b);

    double result[2];
    simde_mm_storeu_pd(result, c);

    printf("Result: %f %f\n", result[0], result[1]);

    return 0;
}