#include <stdio.h>

// Use this
static char largeArray[1024];

void function() {
    // Example function code to demonstrate usage
    largeArray[0] = 'A';
    printf("First character of largeArray: %c\n", largeArray[0]);
}

int main() {
    function();
    return 0;
}