// The provided code is in C++ and uses a class, which is not compatible with C.
// Here is an equivalent version in C, using a struct instead of a class:

#include <stdio.h>

typedef struct Object {
    // Add struct members here as needed
} Object;

Object* getObject() {
    static Object object;
    return &object;
}

int main() {
    // Example usage:
    Object* obj = getObject();
    // printf("%p\n", (void*)obj); // Uncomment to print the memory address of the object
    return 0;
}