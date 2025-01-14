#include <stdio.h>

int main() {
    int var;

    // This will always evaluate to false and the if block will not be executed
    if (var = 0) {
        printf("This will not be printed\n");
    } else {
        printf("This will be printed\n");
    }

    return 0;
}