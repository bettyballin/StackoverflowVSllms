#include <Windows.h>\n\nbool isProcessInForeground(DWORD processId) {\n    HWND foregroundWindow = GetForegroundWindow();\n    if (foregroundWindow == NULL) {\n        return false;\n    }\n\n    DWORD foregroundProcessId;\n    GetWindowThreadProcessId(foregroundWindow, &foregroundProcessId);\n\n    return foregroundProcessId == processId;\n}