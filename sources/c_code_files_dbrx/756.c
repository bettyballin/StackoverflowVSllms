#include <xmmintrin.h> // SSE

void addDoubles(double* destination, double* source1, double* source2, size_t count) {
    __m128d *mmDestination = (__m128d*)destination;
    __m128d *mmSource1 = (__m128d*)source1;
    __m128d *mmSource2 = (__m128d*)source2;

    for(size_t i=0 ; i<count/2 ; ++i) { // count should be multiple of 2
      mmDestination[i] = _mm_add_pd(mmSource1[i], mmSource2[i]);
    }
}

int main() {
    double src1[] = {1.0, 2.0, 3.0, 4.0};
    double src2[] = {5.0, 6.0, 7.0, 8.0};
    double dest[4];

    addDoubles(dest, src1, src2, 4);

    return 0;
}