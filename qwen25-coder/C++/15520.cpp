#include <immintrin.h>\n\nvoid add_arrays(float* out, float* a, float* b, int num_elements) {\n    const int step = 8; // AVX processes 256 bits at a time (8 single precision floats)\n    for (int i = 0; i < num_elements; i += step) {\n        __m256 vec_a = _mm256_loadu_ps(&a[i]);\n        __m256 vec_b = _mm256_loadu_ps(&b[i]);\n        __m256 sum = _mm256_add_ps(vec_a, vec_b);\n        _mm256_storeu_ps(&out[i], sum);\n    }\n}