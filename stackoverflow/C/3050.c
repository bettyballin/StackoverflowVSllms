#include <stdio.h>\n#include <unistd.h>\nstatic char bar[] = "======================================="\n                    "======================================>";\nint main() {\n    int i;\n    for (i = 77; i >= 0; i--) {\n        printf("[%s]\r", &bar[i]);\n        fflush(stdout);\n        sleep(1);\n    }\n    printf("\n");\n    return 0;\n}