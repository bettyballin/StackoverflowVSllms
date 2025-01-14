#include <Windows.h>

int main() {
    // Assuming you have hModuleA and hModuleB loaded somewhere
    HMODULE hModuleA = LoadLibraryA("path/to/DLL_A.dll");
    HMODULE hModuleB = LoadLibraryA("path/to/DLL_B.dll");

    if (hModuleA == NULL || hModuleB == NULL) {
        // Handle the error
        printf("Failed to load one of the DLLs.\n");
        return 1;
    }

    // Rest of your program logic here...

    // Unload DLL B
    if (!FreeLibrary(hModuleB)) {
        // Handle the error
        printf("Failed to unload DLL B.\n");
    }

    // Unload DLL A
    if (!FreeLibrary(hModuleA)) {
        // Handle the error
        printf("Failed to unload DLL A.\n");
    }

    return 0;
}