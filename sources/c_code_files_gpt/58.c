#include <stdio.h>

// Function prototypes
void functionA(void);
void functionB(void);
void mainFunction(void (*func)(void), const char *desc);

// Example functions
void functionA(void) {
    printf("Function A called\n");
}

void functionB(void) {
    printf("Function B called\n");
}

// Main function which takes a function pointer and a description
void mainFunction(void (*func)(void), const char *desc) {
    // <stuff to do>
    func();
    printf("The function %s was called\n", desc);
    // <more stuff to do>
}

int main() {
    // Call mainFunction with functionA
    mainFunction(functionA, "functionA");

    // Call mainFunction with functionB
    mainFunction(functionB, "functionB");

    return 0;
}