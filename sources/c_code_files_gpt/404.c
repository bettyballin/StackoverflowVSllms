// Using a function from a DLL in C
#include <windows.h>
typedef void (*FunctionType)();

int main() {
    HINSTANCE hInst = LoadLibraryA("mydll.dll");
    if (hInst != NULL) {
        FunctionType myFunction = (FunctionType)GetProcAddress(hInst, "MyFunction");
        if (myFunction != NULL) {
            myFunction();
        }
        FreeLibrary(hInst);
    }
    return 0;
}