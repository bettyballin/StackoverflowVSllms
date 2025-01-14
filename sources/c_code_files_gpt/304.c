#include <emmintrin.h>

void process(float *a, float *b, float *c) {
    __asm__ (
        "movaps (%0), %%xmm0\n"
        "movaps (%1), %%xmm1\n"
        "addps %%xmm1, %%xmm0\n"
        "movaps %%xmm0, (%2)\n"
        : // no output operands
        : "r"(a), "r"(b), "r"(c)
        : "%xmm0", "%xmm1"
    );
}

int main() {
    float a[] = {1.0, 2.0, 3.0, 4.0};
    float b[] = {5.0, 6.0, 7.0, 8.0};
    float c[4];

    process(a, b, c);

    return 0;
}