#include <windows.h>\n#include <tchar.h>\n\nvoid exampleFunction() {\n    TCHAR buffer[256];\n    HWND hWnd = GetForegroundWindow();\n    \n    // Replace GetWindowTextA with GetWindowText\n    GetWindowText(hWnd, buffer, 256);\n    \n    // Use _tprintf instead of printf for TCHAR compatibility\n    _tprintf(TEXT("Window Text: %s\n"), buffer);\n}\n\nint main() {\n    exampleFunction();\n    return 0;\n}