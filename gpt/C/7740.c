#include <stdio.h>\n#include <string.h>\n\nint main() {\n    char buffer[100];\n    FILE *stream = fmemopen(buffer, sizeof(buffer), "w+");\n    if (stream == NULL) {\n        perror("fmemopen");\n        return 1;\n    }\n\n    // Potential uninitialized use warning\n    fprintf(stream, "Hello, World!");\n    fclose(stream);\n\n    return 0;\n}