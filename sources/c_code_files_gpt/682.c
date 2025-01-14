#include <stdio.h>

void myfunc(int *a) {
    // Example implementation: prints the value pointed to by 'a'
    printf("The value of 'a' is: %d\n", *a);
}

int main() {
    int x = 10; // Example variable
    myfunc(&x); // Pass the address of 'x' to myfunc
    return 0;
}