#include <stdio.h>\n\nint main() {\n    // Writing to a file\n    FILE *outFile = fopen("example.txt", "w");\n    if (outFile != NULL) {\n        fprintf(outFile, "Hello, World!\n");\n        fprintf(outFile, "%d\n", 123);\n        fclose(outFile);\n    } else {\n        perror("Unable to open file for writing");\n    }\n\n    // Reading from a file\n    FILE *inFile = fopen("example.txt", "r");\n    char line[256];\n    if (inFile != NULL) {\n        while (fgets(line, sizeof(line), inFile)) {\n            printf("%s", line);\n        }\n        fclose(inFile);\n    } else {\n        perror("Unable to open file for reading");\n    }\n\n    return 0;\n}