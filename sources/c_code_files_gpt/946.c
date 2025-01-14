#include <stdio.h>

#pragma GCC push_options
#pragma GCC optimize ("O0")

// Code that causes issues with optimization
int main() {
    printf("Hello, World!\n");
    return 0;
}

#pragma GCC pop_options