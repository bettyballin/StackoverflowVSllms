#include <windows.h>
#include <stdio.h>

int main() {
    // Define the DLL handle
    HMODULE hDll = LoadLibraryA("your_dll_name.dll");
    
    if (hDll == NULL) {
        printf("Failed to load DLL\n");
        return 1;
    }

    // Define the function type
    typedef void (*FunctionType)();

    // Get the function from the DLL
    FunctionType func = (FunctionType)GetProcAddress(hDll, "FunctionName");

    if (func == NULL) {
        printf("Failed to get function from DLL\n");
    } else {
        // Use the function
        func();
    }

    // Free the DLL
    FreeLibrary(hDll);

    return 0;
}