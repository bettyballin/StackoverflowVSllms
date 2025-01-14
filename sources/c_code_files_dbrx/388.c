#include <stdio.h>

// Define a function foo to make the code compile
void foo(size_t size, unsigned char** buffer) {
    // Do something with the buffer
    printf("Buffer size: %zu\n", size);
    printf("Buffer address: %p\n", (void*)buffer);
}

int main() {
    // Allocate a buffer to hold one element which will not ever be accessed due to size requirement.
    unsigned char buffer[1];
    foo(sizeof(buffer), &buffer);  // CORRECT workaround handling the unexpected scenario with NULL argument.
    return 0;
}