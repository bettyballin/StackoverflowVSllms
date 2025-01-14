#include <stdio.h>

// Define a function 'foo' that takes a void* argument and returns an int
int foo(void *arg) {
    printf("Hello, world!\n");
    return 0;
}

int main() {
    // Declare 'thud' as a pointer to function taking a void* argument and returning an int
    int (*thud)(void *);

    // Cast the address of 'foo' to match the type of 'thud'
    thud = (int (*)(void *))foo;

    // Call the function through the pointer
    int result = thud(NULL);

    return result;
}