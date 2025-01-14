#include <windows.h>

int main() {
    HINSTANCE hDll = LoadLibrary("thirdpartylibrary.dll");
    if (hDll == NULL) {
        // Handle the error
        // For demonstration, just print an error message
        printf("Failed to load library.\n");
        return 1; // Indicate failure
    }
    // Add any other code you need here
    FreeLibrary(hDll); // Don't forget to free the library when you're done
    return 0; // Indicate success
}