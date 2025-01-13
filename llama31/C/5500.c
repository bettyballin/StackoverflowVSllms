#include <stdio.h>\n#include <dllloader.h>\n\nint main() {\n    // Load the Windows DLL\n    void* dll_handle = dllloader_load_library("path/to/windows/dll.dll");\n    if (!dll_handle) {\n        printf("Failed to load DLL\n");\n        return 1;\n    }\n\n    // Get the address of a function in the DLL\n    void* func_addr = dllloader_get_proc_address(dll_handle, "SomeFunction");\n    if (!func_addr) {\n        printf("Failed to get function address\n");\n        return 1;\n    }\n\n    // Call the function\n    int result = ((int (*)(void))func_addr)();\n    printf("Result: %d\n", result);\n\n    // Unload the DLL\n    dllloader_free_library(dll_handle);\n    return 0;\n}