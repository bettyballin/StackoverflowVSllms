// Example of using a DLL in C

#include <windows.h>
#include <stdio.h>

typedef int (*AddFunc)(int, int);

int main() {
    HINSTANCE hInstLibrary = LoadLibraryA("example.dll");
    if (hInstLibrary) {
        AddFunc Add = (AddFunc)GetProcAddress(hInstLibrary, "Add");
        if (Add) {
            int result = Add(5, 3);
            printf("Result of Add function: %d\n", result);
        } else {
            printf("Function not found in DLL.\n");
        }
        FreeLibrary(hInstLibrary);
    } else {
        printf("DLL not found.\n");
    }
    return 0;
}