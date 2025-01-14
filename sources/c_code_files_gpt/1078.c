// main.c
#include <windows.h>
#include <stdio.h>

typedef int (__stdcall *Add2Func)(int);
typedef int (__stdcall *MulFunc)(int, int);

int main() {
    HMODULE hDll = LoadLibraryA("mydll.dll");
    if (hDll) {
        Add2Func add2 = (Add2Func)GetProcAddress(hDll, "add2");
        MulFunc mul = (MulFunc)GetProcAddress(hDll, "mul");

        if (add2 && mul) {
            printf("add2(3): %d\n", add2(3));
            printf("mul(4, 5): %d\n", mul(4, 5));
        } else {
            printf("Failed to get function addresses\n");
        }

        FreeLibrary(hDll);
    } else {
        printf("Failed to load DLL\n");
    }

    return 0;
}