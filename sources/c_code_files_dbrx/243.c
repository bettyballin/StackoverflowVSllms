#define _DEBUG  
// In your project settings > Preprocessor Definitions

#include <stdio.h>

int main() {
    #ifdef _DEBUG
        printf("_DEBUG is defined\n");
    #else
        printf("_DEBUG is not defined\n");
    #endif

    return 0;
}