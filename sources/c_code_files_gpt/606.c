#include <stdio.h>

int main() {
    int a = 1;
    int *b = &a; // b is a pointer to 'a'
    int c = *b;  // c is assigned the value of 'a' via dereferencing the pointer 'b'
    printf("%d\n", c); // Print the value of c to verify the code works
    return 0;
}