#include <stdio.h>\n\nunsigned char* ptr; // Assume this is initialized to some memory location\n\n// Check alignment\nif ((uintptr_t)ptr % sizeof(double) == 0) {\n    double d = *((double*)ptr);\n    // Proceed with using d\n} else {\n    // Handle misaligned pointer case\n    fprintf(stderr, "Pointer is not aligned for double\n");\n    // You might need to copy the data to a properly aligned location\n}