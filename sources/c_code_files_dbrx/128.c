#include <stdio.h>
#include <stdlib.h>

// Define custom types
#define TYPE_A 1
#define TYPE_B 2

// Define structs for each type
struct A {
    // Add members as needed
};

struct B {
    // Add members as needed
};

typedef void* Pointer;

Pointer alloc(int type) {
    switch (type) {
        case TYPE_A:
            return malloc(sizeof(struct A));
            break;
        case TYPE_B:
            return malloc(sizeof(struct B));
            break;
        default:
            fprintf(stderr, "Unknown type %d\n", type);
            exit(-1);
    }
}

int main() {
    // Example usage
    Pointer ptr = alloc(TYPE_A);
    // Use ptr...
    free(ptr);
    return 0;
}