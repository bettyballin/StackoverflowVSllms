#include <windows.h>

typedef void (*MYPROC)(LPWSTR); // define function pointer type

int main() {
    HINSTANCE hinstLib;                // handle to the DLL library
    MYPROC ProcAdd;                    // function pointer
    BOOL fFreeResult;
    LPWSTR parm1 = L"Hello, World!";  // define the parameter

    hinstLib = LoadLibrary(TEXT("library.dll"));   // replace "library" appropriately
    if (hinstLib != NULL) {
        ProcAdd = (MYPROC) GetProcAddress(hinstLib, "function"); // replace "function" accordingly
        if (! ProcAdd) {
            // handle error as per your application needs.
            MessageBox(NULL, L"Error: unable to find function in DLL", L"Error", MB_ICONERROR);
        } else{
            // call function through pointer - do this for all other functions.
            (*ProcAdd)(parm1);
        }
        FreeLibrary(hinstLib);
    } else {
        // handle error as per your application needs.
        MessageBox(NULL, L"Error: unable to load DLL", L"Error", MB_ICONERROR);
    }

    return 0;
}