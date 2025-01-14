#include <stdio.h>

__declspec(dllexport) void hello() {
    printf("Hello, World!\n");
}

int main() {
    hello();
    return 0;
}