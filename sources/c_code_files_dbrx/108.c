#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

typedef char* (*GETCPUID)(BYTE);

int main() {
    HINSTANCE hWtsLib = LoadLibrary("your_dll_name.dll"); // Replace with your DLL name
    if (hWtsLib == NULL) {
        printf("Failed to load DLL\n");
        return 1;
    }

    GETCPUID pGetSerial = (GETCPUID)GetProcAddress(hWtsLib, "GetCPUID");
    if (pGetSerial == NULL) {
        printf("Failed to load GetCPUID function\n");
        FreeLibrary(hWtsLib);
        return 1;
    }

    char* str = (char*)malloc(1024);
    if (str == NULL) {
        printf("Memory allocation failed\n");
        FreeLibrary(hWtsLib);
        return 1;
    }

    snprintf(str, 1023, "%s", pGetSerial((BYTE)"1"[0]));
    printf("%s\n", str);

    free(str);
    FreeLibrary(hWtsLib);

    return 0;
}