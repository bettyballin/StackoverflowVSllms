#include <stdio.h>

// Define the function that was previously only declared
static int multiply(int a, int b) {
    return a * b;
}

// This function can be accessed only within this .c file
void func() {
    printf("%d", multiply(5, 6));  // OK as called from the same source
}

// Add a main function to make the code executable
int main() {
    func();
    return 0;
}