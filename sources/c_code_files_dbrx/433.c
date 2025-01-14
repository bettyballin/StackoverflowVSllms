#include <windows.h>
#include <imagehlp.h>
#include <stdio.h>

int main() {
    typedef BOOL (WINAPI *ENUMEXPORT_PROC)(DWORD, PSTR, LPDWORD);
    HMODULE hMod = LoadLibraryA("imagehlp.dll");
    if(hMod != NULL) {
        ENUMEXPORT_PROC fnEnumExports = (ENUMEXPORT_PROC)GetProcAddress(hMod, "EnumExportsW");
        if(fnEnumExports != NULL) {
            // Load the DLL to be scanned.
            HMODULE hDll = LoadLibraryA("yourdllname.dll");
            if(hDll != NULL) {
                BOOL bMore = TRUE;
                while(bMore) {
                    CHAR szExpName[MAX_PATH];
                    DWORD dwSize;
                    // Enumerate the exports in the module.
                    bMore = fnEnumExports((DWORD)hDll, szExpName, &dwSize);
                    if(bMore == TRUE) {
                        printf("%s\n", szExpName);
                    }
                }
            }
            FreeLibrary(hDll);
        }
        FreeLibrary(hMod);
    }
    return 0;
}