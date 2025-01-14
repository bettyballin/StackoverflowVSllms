#include <stdio.h>

// Define a function that matches the expected signature
int add(int a, int b) {
    return a + b;
}

// Define the function pointer type
typedef int (*operationFunc)(int, int);

// Function that takes a function pointer as a parameter
void performOperation(int x, int y, operationFunc op) {
    int result = op(x, y);
    printf("The result is: %d\n", result);
}

int main() {
    // Pass the function pointer to performOperation
    performOperation(5, 3, add);
    return 0;
}