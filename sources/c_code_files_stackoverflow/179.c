#include <stdio.h>
#include <stdlib.h>

// Define a struct to represent A
typedef struct A {
    int dummy;  // Add a dummy member to make the struct non-empty
} A;

int main() {
    A a;
    A* ar = &a;  // both a and ar refer to the same object

    A* temp = malloc(sizeof(A));  // the object created doesn't have a name
    free(temp);  // Don't forget to free the memory to avoid memory leaks

    A* ap = malloc(100 * sizeof(A));  // either all 100 objects share the same name, or need to 
                                      // know that they are part of an array.
    free(ap);  // Don't forget to free the memory to avoid memory leaks

    return 0;
}