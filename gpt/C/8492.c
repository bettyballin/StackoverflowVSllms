#include <stdio.h>\n#include <stdlib.h>\n\nvoid safer_function(size_t size) {\n    // Allocate memory on the heap\n    char *buffer = (char *)malloc(size);\n    if (buffer == NULL) {\n        fprintf(stderr, "malloc failed\n");\n        return;\n    }\n    // Use the buffer\n    for (size_t i = 0; i < size; ++i) {\n        buffer[i] = 'A';\n    }\n    printf("Buffer filled with 'A's\n");\n\n    // Free the allocated memory\n    free(buffer);\n}\n\nint main() {\n    // Safer heap allocation\n    safer_function(1024 * 1024); // 1 MB allocation on heap\n    return 0;\n}