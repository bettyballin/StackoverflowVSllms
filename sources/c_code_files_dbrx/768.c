#include <stdio.h>
#include <stdlib.h>

int main() {
    int number = 10; // assuming number of elements
    int size = sizeof(short int); // assuming size of each element
    short int* array = (short int*)calloc(number * size / sizeof(short int), sizeof(short int));
    if (array == NULL) {
        printf("Memory allocation failed\n");
        return -1;
    }
    printf("Memory allocated successfully\n");
    free(array);
    return 0;
}