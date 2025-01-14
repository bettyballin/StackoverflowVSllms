#include <stdio.h>
#include <stdlib.h>

#define cfree free

int main() {
    int* ptr = malloc(sizeof(int));
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    *ptr = 10;
    printf("Allocated memory and stored the value %d\n", *ptr);

    cfree(ptr);
    printf("Freed the allocated memory\n");

    return 0;
}