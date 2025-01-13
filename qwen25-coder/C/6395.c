#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <errno.h>\n\nint main() {\n    char fpath[256]; // Increased size to accommodate potential full path length\n\n    const char *base_path = "/home/courses1/cs4352/projects/proj0";\n    const char *file = "index.html";\n\n    snprintf(fpath, sizeof(fpath), "%s/%s", base_path, file);\n\n    // Strip any trailing carriage return\n    size_t len = strlen(fpath);\n    if (len > 0 && fpath[len - 1] == '\r') {\n        fpath[len - 1] = '\0';\n    }\n\n    FILE *fp = fopen(fpath, "r");\n    if (fp == NULL) {\n        perror("Failed to open file"); // Use perror() for detailed error messages\n        return EXIT_FAILURE;\n    }\n\n    fclose(fp);\n    printf("File opened successfully.\n");\n\n    // do more stuff\n\n    return EXIT_SUCCESS;\n}