#include <stdio.h>
#include <stddef.h> // Include this for size_t

void test() {
    void *return_address = __builtin_extract_return_addr(__builtin_return_address(0));
    printf("Return address stored on the stack is %p\n", return_address); // Fixed the printf statement
}

int main() {
    for (size_t i = 0; i < 128; ++i) test();
    return 0; // It's good practice to include a return statement in main
}