#include <Windows.h>

int main() {
    // Load the library
    HMODULE lib = LoadLibraryA("kernel32.dll");
    if (lib == NULL) {
        // Handle the error
        return 1;
    }

    // Get the address of the function
    FARPROC func = GetProcAddress(lib, "GetTickCount");
    if (func == NULL) {
        // Handle the error
        FreeLibrary(lib);
        return 1;
    }

    // Call the function
    typedef DWORD (*GetTickCountFunc)(void);
    GetTickCountFunc getTickCount = (GetTickCountFunc)func;
    DWORD tickCount = getTickCount();

    // Print the result
    printf("Tick count: %u\n", tickCount);

    // Free the library
    FreeLibrary(lib);

    return 0;
}