#include <windows.h>
#include <stdio.h>

typedef short int (__stdcall *vbfun)(short int);

int main() {
    vbfun popup_message;
    HINSTANCE dllhnd;

    dllhnd = LoadLibrary("vbdll.dll");
    if (dllhnd != NULL) {
        popup_message = (vbfun)GetProcAddress(dllhnd, "PopupMessage");
        if (popup_message != NULL) {
            short result = popup_message(3);
            printf("%d", result);
        } else {
            printf("Function not found.\n");
        }
        FreeLibrary(dllhnd);
    } else {
        printf("DLL not loaded.\n");
    }
    return 0;
}