#include <stdio.h>

void myfunc(int* b) {
    // Change the value of b to demonstrate pass by reference
    (*b)++;
}

int main() {
    int b = 5;
    printf("Before calling myfunc, b = %d\n", b);
    myfunc(&b); // Caller is aware that b is being passed by reference
    printf("After calling myfunc, b = %d\n", b);
    return 0;
}