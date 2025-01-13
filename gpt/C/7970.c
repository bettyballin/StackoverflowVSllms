#include <stdio.h>\n#include <string.h>\n#include <errno.h>\n\nint main(int argc, char *argv[]) {\n    char prog_name[128];\n    if (argc > 0) {\n        errno_t err = strcpy_s(prog_name, sizeof(prog_name), argv[0]);\n        if (err != 0) {\n            fprintf(stderr, "Error copying string: %d\n", err);\n            return 1;\n        }\n    }\n    printf("Program name: %s\n", prog_name);\n    return 0;\n}