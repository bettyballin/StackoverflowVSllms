#include <stdio.h>\n#include <stdlib.h>\n\nvoid readFileUptoPosition(const char *filename, long position) {\n    FILE *file = fopen(filename, "r");\n    if (file == NULL) {\n        perror("Error opening file");\n        exit(EXIT_FAILURE);\n    }\n\n    char *buffer = (char *)malloc(position + 1); // Allocate memory for the buffer\n    if (buffer == NULL) {\n        perror("Error allocating memory");\n        fclose(file);\n        exit(EXIT_FAILURE);\n    }\n\n    size_t bytesRead = fread(buffer, 1, position, file);\n    if (bytesRead < position) {\n        if (feof(file)) {\n            printf("Reached end of file.\n");\n        } else {\n            perror("Error reading file");\n            free(buffer);\n            fclose(file);\n            exit(EXIT_FAILURE);\n        }\n    }\n\n    buffer[bytesRead] = '\0'; // Null-terminate the string\n    printf("Read content: %s\n", buffer);\n\n    free(buffer);\n    fclose(file);\n}\n\nint main(int argc, char *argv[]) {\n    if (argc != 3) {\n        fprintf(stderr, "Usage: %s <filename> <position>\n", argv[0]);\n        exit(EXIT_FAILURE);\n    }\n\n    const char *filename = argv[1];\n    long position = atol(argv[2]);\n\n    readFileUptoPosition(filename, position);\n\n    return 0;\n}