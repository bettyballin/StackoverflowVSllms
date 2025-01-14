#include <stdio.h>

void my_function() {
    printf("Hello from the dynamically loaded library!\n");
}

int main() {
    my_function();
    return 0;
}