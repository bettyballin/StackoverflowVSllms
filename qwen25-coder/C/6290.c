#include <stdio.h>\n#include <sys/types.h>\n#include <unistd.h>\n\nint main() { \n    if (setuid(65534) == -1) {\n        perror("Failed to setuid");\n        return 1;\n    }\n    while (1);\n    return 0;\n}