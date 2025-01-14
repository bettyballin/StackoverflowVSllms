#include <windows.h>
#include <stdio.h>

typedef BOOL (*INITINSTANCE)();

int main() {
    HMODULE hExe = LoadLibraryA("your_program.exe"); // Changed to LoadLibraryA for explicit ANSI version
    if (hExe == NULL) {
        printf("Failed to load executable.\n"); // Added newline character
        return 1;
    }

    INITINSTANCE InitInstance = (INITINSTANCE)GetProcAddress(hExe, "InitInstance");
    if (InitInstance == NULL) {
        printf("Failed to find InitInstance function.\n"); // Added newline character
        FreeLibrary(hExe);
        return 1;
    }

    if (!InitInstance()) {
        printf("Initialization failed.\n"); // Added newline character
        FreeLibrary(hExe);
        return 1;
    }

    // Use other exported functions as needed

    // Clean up
    FreeLibrary(hExe);
    return 0;
}