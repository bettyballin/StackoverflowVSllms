#include <stdio.h>\n\nint main() {\n    FILE *file = fopen("example.txt", "w");\n    if (file == NULL) {\n        // handle error\n    }\n\n    // Disable buffering\n    setvbuf(file, NULL, _IONBF, 0);\n\n    int bytes_written = fprintf(file, "Hello, world!\n");\n    if (bytes_written < 0) {\n        // handle error\n    }\n\n    fclose(file);\n    return 0;\n}