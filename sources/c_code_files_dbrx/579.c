#include <windows.h>

int main() {
    HMODULE modHandle1 = LoadLibraryA("MyDll1.dll");
    HMODULE modHandle2 = LoadLibraryA("MyDll2.dll");

    // call functions from DLLs using GetProcAddress function
    if (modHandle1 && modHandle2) {
        // assuming MyFunction is a function in the DLLs
        typedef void (*MyFunctionPtr)();
        MyFunctionPtr func1 = (MyFunctionPtr)GetProcAddress(modHandle1, "MyFunction");
        MyFunctionPtr func2 = (MyFunctionPtr)GetProcAddress(modHandle2, "MyFunction");

        if (func1 && func2) {
            func1();
            func2();
        }
    }

    // free library afterwards if needed
    if (modHandle1) {
        FreeLibrary(modHandle1);
    }
    if (modHandle2) {
        FreeLibrary(modHandle2);
    }

    return 0;
}