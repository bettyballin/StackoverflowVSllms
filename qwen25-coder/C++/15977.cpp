// Injector.cpp\n\n#include <windows.h>\n#include "PathToYourDetoursHeaders\detours.h"\n\ntypedef void(*STARTER)();\n\nBOOL WINAPI DllMain(HINSTANCE hinstDLL, DWORD fdwReason, LPVOID lpvReserved)\n{\n    if (fdwReason == DLL_PROCESS_ATTACH)\n    {\n        DisableThreadLibraryCalls(hinstDLL);\n    }\n    return TRUE;\n}\n\nvoid InjectorFunction(DWORD processID, const char* dllPath)\n{\n    HMODULE hDll = InjectDLL(processID, dllPath);  // Your function to inject DLL\n\n    if (hDll != NULL)\n    {\n        STARTER Starter = (STARTER)GetProcAddress(hDll, "Starter");\n\n        if (Starter != NULL)\n            Starter();\n    }\n}\n\nint main()\n{\n    STARTUPINFO si = { sizeof(STARTUPINFO) };\n    PROCESS_INFORMATION pi = { 0 };\n\n    DetourCreateProcessWithDll(L"Application.exe", NULL, NULL, NULL, TRUE,\n                               CREATE_DEFAULT_ERROR_MODE | CREATE_SUSPENDED, NULL, L"C:\\path\\to\\working\\dir",\n                               &si, &pi, detoured, hook, NULL);\n\n    InjectorFunction(pi.dwProcessId, "C:\\path\\to\\your.dll");\n\n    ResumeThread(pi.hThread);\n    WaitForSingleObject(pi.hProcess, INFINITE);\n}