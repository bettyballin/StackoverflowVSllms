#include <stdio.h>\n#include <limits.h>\n\nint main() {\n    printf("Size of int: %zu bits\n", sizeof(int) * CHAR_BIT);\n    printf("Size of long: %zu bits\n", sizeof(long) * CHAR_BIT);\n    printf("Size of pointer: %zu bits\n", sizeof(void*) * CHAR_BIT);\n\n    return 0;\n}