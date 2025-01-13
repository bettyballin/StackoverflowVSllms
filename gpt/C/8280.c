// Using fread()\n#include <stdio.h>\n\nint main() {\n    FILE *file = fopen("example.txt", "r");\n    if (file == NULL) {\n        perror("fopen");\n        return 1;\n    }\n\n    char buffer[128];\n    size_t bytesRead = fread(buffer, 1, sizeof(buffer), file);\n    if (bytesRead < sizeof(buffer) && ferror(file)) {\n        perror("fread");\n        return 1;\n    }\n\n    // Process buffer...\n    fclose(file);\n    return 0;\n}