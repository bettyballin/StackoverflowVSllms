#include <immintrin.h>\n#include <stdio.h>\n\nvoid add_arrays(double *a, double *b, double *result, int n) {\n    for (int i = 0; i < n; i += 4) {\n        __m256d va = _mm256_loadu_pd(&a[i]);\n        __m256d vb = _mm256_loadu_pd(&b[i]);\n        __m256d vresult = _mm256_add_pd(va, vb);\n        _mm256_storeu_pd(&result[i], vresult);\n    }\n}\n\nint main() {\n    double a[8] = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};\n    double b[8] = {9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0};\n    double result[8];\n    \n    add_arrays(a, b, result, 8);\n\n    for (int i = 0; i < 8; i++) {\n        printf("%f ", result[i]);\n    }\n\n    return 0;\n}