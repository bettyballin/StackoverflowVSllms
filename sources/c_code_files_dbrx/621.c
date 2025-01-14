#include <stdio.h>
#include <stdlib.h>
#include <curand.h>

int main() {
    curandGenerator_t gen;
    unsigned long seed = 0x1234ABCDL; // just some seed value
    const int size = 10; // size of requested random numbers
    float* output;   // Output array pointer

    // Allocate memory for output array
    output = (float*)malloc(size * sizeof(float));

    curandCreateGenerator(&gen, CURAND_RNG_PSEUDO_DEFAULT);    /* Create generators */
    curandSetPseudoRandomGeneratorSeed(gen, seed);  /* Initialize generator state */
    curandGenerateUniform(gen, output, size);        /* Generate random numbers */

    // Print generated random numbers
    for (int i = 0; i < size; i++) {
        printf("%f ", output[i]);
    }
    printf("\n");

    // Clean up
    curandDestroyGenerator(gen);
    free(output);

    return 0;
}