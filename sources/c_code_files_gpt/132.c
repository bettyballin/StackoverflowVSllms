#include <windows.h>
#include <stdio.h>

int main() {
    HMODULE hDll = LoadLibrary("example.dll");
    if (hDll == NULL) {
        // Basic error handling
        DWORD errorCode = GetLastError();
        printf("Failed to load DLL. Error code: %d\n", errorCode);
        return -1;
    }

    // Use the DLL's functions...

    // Free the DLL when done
    if (!FreeLibrary(hDll)) {
        DWORD errorCode = GetLastError();
        printf("Failed to free DLL. Error code: %d\n", errorCode);
        return -1;
    }

    return 0;
}