#include <Windows.h>\n\nint main() {\n    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);\n    if (hConsole != INVALID_HANDLE_VALUE) {\n        SMALL_RECT rect = { 0, 0, 120, 50 }; // width = 120, height = 50\n        SetConsoleWindowInfo(hConsole, TRUE, &rect);\n    }\n    return 0;\n}