#include <unistd.h>\n\nint main() {\n    // Set the length of the file to 1024 bytes\n    if (truncate("example.txt", 1024) == -1) {\n        perror("truncate");\n        return 1;\n    }\n    return 0;\n}