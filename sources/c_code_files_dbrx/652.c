#include <Windows.h>

int main() {
    typedef void (*FunctionPtr)(void);  // Define the function pointer type.
    HINSTANCE hinstDLL;                // Get a handle to the DLL module.
    hinstDLL = LoadLibraryA("MyLib.dll");         // Handle to MyLib.dll.
    if (hinstDLL != NULL) {
        FunctionPtr lpfnDllFunc1;        // Function pointer.
        lpfnDllFunc1=(FunctionPtr) GetProcAddress(hinstDLL, "Init");  // Get function address.
        if (lpfnDllFunc1 != NULL)  // If function exists, call it.
            (*lpfnDllFunc1)();
        BOOL fFreeResult = FreeLibrary(hinstDLL);   // Unload DLL module.
    }
    return 0;
}