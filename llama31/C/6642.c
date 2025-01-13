#include <stdio.h>\n\nint main() {\n    FILE *stream = fopen("example.txt", "r");\n    if (stream == NULL) {\n        // handle error\n        return 1;\n    }\n\n    // read data...\n    while (!feof(stream)) {\n        // ...\n    }\n\n    if (fclose(stream) != 0) {\n        // handle error\n        return 1;\n    }\n\n    // don't use feof() here, it's undefined behavior\n    return 0;\n}