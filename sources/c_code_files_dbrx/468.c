#include <windows.h>

typedef int (*FunctionType)(int, char*);

int main() {
    HMODULE hModule = LoadLibrary("dllname.dll");
    if (!hModule) {
        // error handling
        return 1;
    }

    FunctionType YourDLLFunc = (FunctionType)GetProcAddress(hModule, "YourDLLFuncName");
    if (!YourDLLFunc) {
        // error handling
        FreeLibrary(hModule);
        return 1;
    }

    int param1 = 1; // Replace with your own value
    char* param2 = "Hello"; // Replace with your own value
    int result = YourDLLFunc(param1, param2);

    FreeLibrary(hModule);
    return 0;
}