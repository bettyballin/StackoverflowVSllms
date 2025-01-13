#include <windows.h>\n\nint main() {\n    // Load the Win32 DLL\n    HMODULE hModule = LoadLibraryA("path/to/your/dll.dll");\n    if (!hModule) {\n        // Handle error\n    }\n\n    // Get the address of a function in the DLL\n    FARPROC pFunc = GetProcAddress(hModule, "YourFunctionName");\n    if (!pFunc) {\n        // Handle error\n    }\n\n    // Call the function\n    pFunc();\n\n    // Clean up\n    FreeLibrary(hModule);\n    return 0;\n}