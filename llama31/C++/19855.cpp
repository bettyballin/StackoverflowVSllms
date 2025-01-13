// Within the DLL, implement a function that will be called when all objects are released\nvoid CALLBACK ReleaseDll(HMODULE hModule) {\n    // It's safe to call FreeLibrary here because we're not executing from within the DLL's code anymore\n    FreeLibrary(hModule);\n}\n\n// Within the DLL, increment and decrement a reference count for each object creation/destruction\nclass Object {\npublic:\n    Object() {\n        InterlockedIncrement(&g_refCount);\n    }\n    ~Object() {\n        if (InterlockedDecrement(&g_refCount) == 0) {\n            // Last object was released, schedule the DLL to be unloaded\n            ReleaseDll(GetModuleHandle(NULL));\n        }\n    }\n};\n\n// Global reference count\nvolatile LONG g_refCount = 0;