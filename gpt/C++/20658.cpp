#include <windows.h>\n\nint main() {\n    // Create a new console\n    AllocConsole();\n    // Now you can use standard I/O functions like printf, scanf, etc.\n    printf("This is a new console window.\n");\n    return 0;\n}