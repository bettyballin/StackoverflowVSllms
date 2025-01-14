#include <stdio.h>

// Function declaration
void func(void (*f)(int));

// Example function that takes an int and prints it
void printInt(int n) {
    printf("%d\n", n);
}

// Implementation of func: calls the function passed to it with the argument 5
void func(void (*f)(int)) {
    f(5);
}

int main() {
    // Pass printInt to func
    func(printInt);
    return 0;
}