// MainProgram.c
#include <windows.h>
#include <stdio.h>

typedef void (*FunctionA_t)();

int main() {
    HMODULE hModuleA = LoadLibrary("ModuleA.dll");
    if (hModuleA == NULL) {
        printf("Failed to load ModuleA.dll\n");
        return 1;
    }

    FunctionA_t FunctionA = (FunctionA_t)GetProcAddress(hModuleA, "FunctionA");
    if (FunctionA == NULL) {
        printf("Failed to get address of FunctionA\n");
        FreeLibrary(hModuleA);
        return 1;
    }

    FunctionA();

    FreeLibrary(hModuleA);
    return 0;
}