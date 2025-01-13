#include <stdio.h>\n#include <stddef.h>\n\nstruct Example {\n    int values[3];\n};\n\nint main() {\n    printf("Size of int: %zu\n", sizeof(int));\n    printf("Offset of values[0]: %zu\n", offsetof(struct Example, values));\n    printf("Offset of values[1]: %zu\n", offsetof(struct Example, values) + sizeof(int));\n    printf("Offset of values[2]: %zu\n", offsetof(struct Example, values) + 2 * sizeof(int));\n    return 0;\n}