#include <stdio.h>\n\nint main(void) {\n    int i = 0;\n\n    if (i += 1 && printf("%d\n", i)) {\n        printf("Done: %d.\n", i);\n    }\n}