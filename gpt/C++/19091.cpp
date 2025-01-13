#include <windows.h>\n#include <iostream>\n#include <stdio.h>\n\nHINSTANCE hinst;\nHHOOK hhk;\n\nLRESULT CALLBACK wireKeyboardProc(int code, WPARAM wParam, LPARAM lParam) {  \n    if (code < 0) {\n        return CallNextHookEx(hhk, code, wParam, lParam);\n    }\n    Beep(1000, 20);\n    return CallNextHookEx(hhk, code, wParam, lParam);\n}\n\nextern "C" __declspec(dllexport) void install(unsigned long threadID) { \n    hhk = SetWindowsHookEx(WH_KEYBOARD, wireKeyboardProc, hinst, threadID);\n    if (!hhk) {\n        // Handle error\n        DWORD error = GetLastError();\n        printf("Failed to install hook! Error: %lu\n", error);\n    }\n}\n\nextern "C" __declspec(dllexport) void uninstall() {\n    if (hhk) {\n        UnhookWindowsHookEx(hhk);\n        hhk = NULL;\n    }\n}\n\nBOOL WINAPI DllMain(HINSTANCE hinstDLL, DWORD fdwReason, LPVOID lpvReserved) {\n    if (fdwReason == DLL_PROCESS_ATTACH) {\n        hinst = hinstDLL;\n    }\n    return TRUE;\n}