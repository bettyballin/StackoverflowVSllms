// ClientApp.c

// Since MyLibrary.h is not provided, let's define the necessary elements here for demonstration.
#ifndef MYLIBRARY_H
#define MYLIBRARY_H

// Normally, these definitions would be in MyLibrary.h
void Function1(void);
void Function2(void);
extern int Variable1; // Using extern to declare a global variable that's defined elsewhere

#endif // MYLIBRARY_H

// Normally, these definitions would be in MyLibrary.c or another source file
void Function1(void) {
    // Example implementation
    printf("Function1 called\n");
}

void Function2(void) {
    // Example implementation
    printf("Function2 called\n");
}

int Variable1 = 10; // Define the global variable

#include <stdio.h> // Include for printf

int main() {
    Function1();
    Function2();
    int value = Variable1;
    printf("Value of Variable1: %d\n", value); // Print the value to verify
    return 0; // Return an integer as per the main function's return type
}