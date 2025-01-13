#include <stdio.h>\n#include <stdlib.h>\n\nint main() {\n    char *homepath = getenv("HOMEPATH");\n    if (homepath != NULL) {\n        char filename[256];\n        sprintf(filename, "C:\\%s\\desktop\\helloworld.txt", homepath);\n        FILE *fd = fopen(filename, "w");\n        if (fd != NULL) {\n            // Write to the file\n            fprintf(fd, "Hello, World!");\n            fclose(fd);\n        } else {\n            printf("Error opening file\n");\n        }\n    } else {\n        printf("HOMEPATH environment variable not set\n");\n    }\n    return 0;\n}