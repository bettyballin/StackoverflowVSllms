#include <Windows.h>\n\n// ...\n\nint main() {\n    // ...\n\n    HANDLE hErrorFile = CreateFileA("C:\\Path\\To\\ErrorLog.txt", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);\n    if (hErrorFile != INVALID_HANDLE_VALUE) {\n        SetStdHandle(STD_ERROR_HANDLE, hErrorFile);\n    }\n\n    // ...\n}