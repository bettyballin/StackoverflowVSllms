#include <stdio.h>

// Define the type sometype as a struct with a function pointer
typedef struct {
    void (*func)(void);
} sometype;

// Define a function to be called on the sometype struct
void my_func() {
    printf("Hello, world!\n");
}

// Define the foo function
void foo(sometype *p) {
    p->func();
}

int main() {
    // Create a sometype struct and set its function pointer
    sometype s;
    s.func = my_func;

    // Call the foo function with the sometype struct
    foo(&s);

    return 0;
}