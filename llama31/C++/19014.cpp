#include <windows.h>\n#include <iostream>\n\nclass Console {\npublic:\n    static void Print(const char* message) {\n        std::cout << message;\n    }\n\n    static void Warning(const char* message) {\n        HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);\n        SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN);\n        std::cout << message;\n        SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE);\n    }\n\n    static void Error(const char* message) {\n        HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);\n        SetConsoleTextAttribute(hConsole, FOREGROUND_RED);\n        std::cout << message;\n        SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE);\n    }\n};