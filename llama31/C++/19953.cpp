#include <Windows.h>\n\nHHOOK hookHandle;\n\nLRESULT CALLBACK ScreenshotHook(int nCode, WPARAM wParam, LPARAM lParam) {\n    if (nCode == HC_ACTION) {\n        // Check if the system call is BitBlt or PrintWindow\n        if (wParam == (LPARAM)BitBlt || wParam == (LPARAM)PrintWindow) {\n            // Handle the screenshot event\n            // ...\n        }\n    }\n    return CallNextHookEx(hookHandle, nCode, wParam, lParam);\n}\n\nint main() {\n    hookHandle = SetWindowsHookEx(WH_CALLWNDPROC, ScreenshotHook, NULL, GetCurrentThreadId());\n    if (hookHandle) {\n        // Hook installed successfully\n    } else {\n        // Error installing hook\n    }\n    return 0;\n}