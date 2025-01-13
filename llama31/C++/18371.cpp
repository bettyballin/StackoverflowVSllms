// mylib.dll\nextern "C" __declspec(dllexport) int add(int a, int b) {\n    return a + b;\n}\n\n// myprogram.exe\n#include <Windows.h>\nint main() {\n    HMODULE hModule = LoadLibraryA("mylib.dll");\n    if (hModule) {\n        int (*add)(int, int) = (int (*)(int, int))GetProcAddress(hModule, "add");\n        if (add) {\n            int result = add(2, 3);\n            printf("%d\n", result);\n        }\n        FreeLibrary(hModule);\n    }\n    return 0;\n}