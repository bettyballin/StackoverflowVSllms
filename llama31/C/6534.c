#include <stdio.h>\n\nint main() {\n    setvbuf(stdout, NULL, _IONBF, 0);  // Disable buffering\n    printf("Hello, World!");  // No newline character appended\n    return 0;\n}