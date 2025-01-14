#include <stdio.h>

int main() {
    void *somePtr = NULL;

    if (somePtr == NULL) {
        printf("This will be executed if somePtr is equal to NULL\n");
    } else if (somePtr != NULL) {
        printf("This block won't be executed in the current case as 'somePtr' is assigned NULL, but this is an example of explicit check for non-NULL value.\n");
    }

    return 0;
}