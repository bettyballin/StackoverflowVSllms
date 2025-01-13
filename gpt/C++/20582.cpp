#include <windows.h>\n\nBOOL WINAPI DllMain(HINSTANCE hinstDLL, DWORD fdwReason, LPVOID lpvReserved) {\n    switch (fdwReason) {\n        case DLL_PROCESS_ATTACH:\n            // Perform initialization tasks if needed\n            break;\n        case DLL_THREAD_ATTACH:\n        case DLL_THREAD_DETACH:\n        case DLL_PROCESS_DETACH:\n            // Perform cleanup tasks if needed\n            break;\n    }\n    return TRUE;\n}\n\nextern "C" __declspec(dllexport) void InitializeLibrary() {\n    char dllPath[MAX_PATH];\n    if (GetModuleFileNameA((HMODULE)hinstDLL, dllPath, MAX_PATH) != 0) {\n        // Extract directory from the full path\n        PathRemoveFileSpecA(dllPath);\n        SetDllDirectoryA(dllPath);\n        \n        // Perform other initialization tasks\n        \n        // Reset DLL search path to default after use\n        SetDllDirectoryA(NULL);\n    }\n}