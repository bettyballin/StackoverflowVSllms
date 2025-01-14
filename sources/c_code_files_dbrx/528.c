#include <windows.h>

typedef int (*IsolatedFuncPtr)(int param); // Declare a pointer type for the function in DLL to be called.
HINSTANCE hinstDll;   // Handle of instance of DLL module
IsolatedFuncPtr IsolatedFunction;  // Function pointer declaration.
BOOL fFreeResult, fRunTimeLinkSuccess = FALSE;

int main(){
    // Get pointer to desired exported functions from specific loaded library and store it in the function pointer variable.
    hinstDll = LoadLibrary("My_dll.dll");  // Handle of DLL containing IsolatedFunction().
    if ( NULL != hinstDll ) {
        fRunTimeLinkSuccess = TRUE;
        IsolatedFunction = (IsolatedFuncPtr)GetProcAddress(hinstDll, "IsolatedFunction"); // Get address to function in DLL.
    }
    if (fRunTimeLinkSuccess){ // If you managed to get a pointer to your desired funcion and the handle is valid, call it using the pointer.
        int someParam = 10;  // Define someParam before using it
        int result = (*IsolatedFunction)(someParam);
    }
    return 0;  // Add a return statement to the main function
}