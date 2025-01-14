#include <stdio.h>

// Define the function that was previously declared as extern
void my_function() {
    printf("Hello, World!\n");
}

int main() {
    my_function();
    return 0;
}