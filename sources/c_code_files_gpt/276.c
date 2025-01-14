#include <windows.h>
#include <commctrl.h>
#include <stdio.h>

typedef void (WINAPI *INITCOMMONCONTROLSEX)(LPINITCOMMONCONTROLSEX);

int main() {
    HMODULE hComCtl = LoadLibraryA("comctl32.dll");
    if (hComCtl == NULL) {
        printf("Failed to load comctl32.dll\n");
        return 1;
    }

    INITCOMMONCONTROLSEX pInitCommonControlsEx = (INITCOMMONCONTROLSEX)GetProcAddress(hComCtl, "InitCommonControlsEx");
    if (pInitCommonControlsEx == NULL) {
        printf("Failed to get InitCommonControlsEx function address\n");
        FreeLibrary(hComCtl);
        return 1;
    }

    INITCOMMONCONTROLSEX icex;
    icex.dwSize = sizeof(icex);
    icex.dwICC = ICC_WIN95_CLASSES;
    pInitCommonControlsEx(&icex);

    // Your application code here...

    FreeLibrary(hComCtl);
    return 0;
}