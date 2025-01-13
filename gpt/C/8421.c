#include <stdio.h>\n#include <string.h>\n\nint main(int argc, char *argv[]) {\n    char prog_name[128];\n    if (argc > 0) {\n        strncpy(prog_name, argv[0], sizeof(prog_name) - 1);\n        prog_name[sizeof(prog_name) - 1] = '\0'; // Ensure null-termination\n    }\n    printf("Program name: %s\n", prog_name);\n    return 0;\n}