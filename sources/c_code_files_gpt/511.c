#include <stdio.h>

int main() {
    void *somePtr = NULL;

    if (!somePtr) {
        /* This will always be executed */
        printf("This will always be executed because somePtr is NULL.\n");
    }

    return 0;
}