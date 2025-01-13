// caller.cpp\nint main() {\n    HMODULE hModule = LoadLibraryA("MyDll.dll");\n    if (hModule) {\n        FARPROC pFunc = GetProcAddress(hModule, (LPCSTR)1); // Use the ordinal\n        if (pFunc) {\n            int result = ((int(*)(int))pFunc)(5);\n            // ...\n        }\n        FreeLibrary(hModule);\n    }\n    return 0;\n}