#include <stdio.h>
#include <stdlib.h>

void foo(int a, void* b) {
    if (b == NULL) {
        printf("Error: NULL pointer passed to foo\n");
        exit(EXIT_FAILURE);
    }
    // rest of the function implementation...
}

int main() {
    foo(0, NULL); // INCORRECT invocation expecting error
    return 0;
}