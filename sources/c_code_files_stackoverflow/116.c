#include <stdio.h>

__declspec(dllexport) void myExportedFunction() {
    printf("Hello from exported function!\n");
}

int main() {
    myExportedFunction();
    return 0;
}