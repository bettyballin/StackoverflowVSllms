#include <immintrin.h>\n\nvoid avxExample(float *a, float *b, float *result) {\n    __m256 vectorA = _mm256_loadu_ps(a); // Load 8 floats from 'a'\n    __m256 vectorB = _mm256_loadu_ps(b); // Load 8 floats from 'b'\n    __m256 vectorResult = _mm256_add_ps(vectorA, vectorB); // Add vectors\n    _mm256_storeu_ps(result, vectorResult); // Store result\n}