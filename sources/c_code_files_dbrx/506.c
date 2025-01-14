#include <stdio.h>

void unoptimized_function() __attribute__ ((optimize("0")));

void unoptimized_function() {
    // Function body here
    printf("This is an unoptimized function.\n");
}

int main() {
    unoptimized_function();
    return 0;
}