#include <stdio.h>

int main() {
    #if _WIN64
        printf("This is a 64-bit build.\n");
    #else
        printf("This is a 32-bit build.\n");
    #endif
    return 0;
}