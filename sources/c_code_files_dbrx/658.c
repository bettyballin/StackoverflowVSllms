#include <windows.h>   // For LoadLibrary and GetProcAddress
#include <stdio.h>     // For perror

typedef int (WINAPI *DLLFunc)(int arg1, char* arg2);  // Function pointer type for DLL function

int main() {
    HINSTANCE hinstLib;   // Handle to DLL
    DLLFunc func_ptr;      // Function pointer
    BOOL bResult;         // Flag for result of attempts to load/find functions
    int iArg1 = 5, iRetval;    // Local variables used with function call. Use as needed.
    char *arg2 = "Hello!";

    hinstLib = LoadLibraryA("mydll.dll"); // Load DLL into RAM, assign handle if succeeded.
    if (!hinstLib) {   // If failed: Display error message then immediately exit.
        perror ("Error while loading mydll: ");
        return -1;
    }

    // Define function pointer and point it to the dll's function address
    func_ptr = (DLLFunc) GetProcAddress(hinstLib, "NameOfTheFunction");
    if (!func_ptr) {   // If failed: Display error message then immediately exit.
        perror ("Error while getting procedure address from mydll: ");
        return -2;
    }

    iRetval = func_ptr(iArg1, arg2);    // Make function call
    printf("Result returned by the DLL's function is %d.\n", iRetval);

    bResult = FreeLibrary(hinstLib);   // Unload DLL from RAM once done.
    if (!bResult) {     // If failed: Display error message then immediately exit.
        perror("Error while unloading mydll: ");
        return -3;
    }

    return 0;
}