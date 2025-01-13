#include <stdio.h>\n\nint main(int argc, char *argv[]) {\n    if (argc != 2) {\n        fprintf(stderr, "Usage: %s filename\n", argv[0]);\n        return 1;\n    }\n\n    const char *filename = argv[1];\n\n    // Example of opening the file\n    FILE *file = fopen(filename, "r");\n    if (!file) {\n        perror("Error opening file");\n        return 1;\n    }\n\n    printf("File successfully opened: %s\n", filename);\n\n    // Always close the file when done\n    fclose(file);\n    return 0;\n}