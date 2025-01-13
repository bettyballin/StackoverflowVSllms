#include <stdio.h>\n#include <stdlib.h>\n#include <time.h>\n\nvoid matrixMultiply(int n) {\n    int i, j, k;\n    double **a = malloc(n * sizeof(double *));\n    double **b = malloc(n * sizeof(double *));\n    double **c = malloc(n * sizeof(double *));\n    \n    for (i = 0; i < n; i++) {\n        a[i] = malloc(n * sizeof(double));\n        b[i] = malloc(n * sizeof(double));\n        c[i] = malloc(n * sizeof(double));\n    }\n    \n    // Initialize matrices with random values\n    srand(time(NULL));\n    for (i = 0; i < n; i++) {\n        for (j = 0; j < n; j++) {\n            a[i][j] = rand() % 100;\n            b[i][j] = rand() % 100;\n            c[i][j] = 0;\n        }\n    }\n\n    // Matrix multiplication\n    for (i = 0; i < n; i++) {\n        for (j = 0; j < n; j++) {\n            for (k = 0; k < n; k++) {\n                c[i][j] += a[i][k] * b[k][j];\n            }\n        }\n    }\n\n    // Free memory\n    for (i = 0; i < n; i++) {\n        free(a[i]);\n        free(b[i]);\n        free(c[i]);\n    }\n    free(a);\n    free(b);\n    free(c);\n}\n\nint main() {\n    int n = 500; // Size of the NxN matrix\n    matrixMultiply(n);\n    return 0;\n}