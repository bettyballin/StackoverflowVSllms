#include <stdio.h>\n#include <stdlib.h>\n#include <stdint.h>\n#include <string.h>\n\nshort int* mallocStuff(long int number, short int base) {\n    short int *array;\n    int size = 1024;\n\n    // Allocate memory with calloc, which will zero-initialize it\n    array = (short int*)calloc(1, size);\n    return array;\n}\n\nint main() {\n    short int **translatedArray;\n\n    // Allocate memory for an array of 4 short int pointers\n    translatedArray = (short int**)malloc(4 * sizeof(short int*));\n\n    for(int i = 0; i < 4; i++) {\n        // Call mallocStuff which allocates 1024 bytes\n        translatedArray[i] = mallocStuff(0, 0);\n\n        if(i > 0) {\n            // Print the difference in addresses\n            printf("\n   block size (for a): %p-%p : %li",\n                (void*)translatedArray[i], (void*)translatedArray[i-1], (uintptr_t)translatedArray[i] - (uintptr_t)translatedArray[i-1]);\n        }\n    }\n\n    // Free allocated memory\n    for(int i = 0; i < 4; i++) {\n        free(translatedArray[i]);\n    }\n    free(translatedArray);\n\n    return 0;\n}