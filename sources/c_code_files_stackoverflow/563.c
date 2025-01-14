#include <stdio.h>

void __attribute__((deprecated)) deprecated_function() {
    printf("This function is deprecated!\n");
}

int main() {
    deprecated_function();
    return 0;
}