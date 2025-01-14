#include <windows.h>

int main() {
    HMODULE hDll;
    // Assume that hDll has been loaded with LoadLibrary function
    FreeLibrary(hDll);
    return 0;
}