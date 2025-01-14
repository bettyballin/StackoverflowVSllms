#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
  int myint;
  char* mystring;
} data;

int main() {
    // Allocate memory for an array of 5 pointers to data
    data** array = (data**)malloc(5 * sizeof(data*));
    if (array == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // For each element in the array, allocate memory for a data structure
    for (int i = 0; i < 5; i++) {
        array[i] = (data*)malloc(sizeof(data));
        if (array[i] == NULL) {
            printf("Memory allocation failed for array element %d\n", i);
            return 1;
        }

        // Example: Initialize the data structure with some values
        array[i]->myint = i;
        array[i]->mystring = (char*)malloc(10 * sizeof(char)); // Example size
        if (array[i]->mystring == NULL) {
            printf("Memory allocation failed for string in array element %d\n", i);
            return 1;
        }
        sprintf(array[i]->mystring, "String %d", i);
    }

    // Example: Print the values
    for (int i = 0; i < 5; i++) {
        printf("Array element %d: int = %d, string = %s\n", i, array[i]->myint, array[i]->mystring);
    }

    // Free the allocated memory
    for (int i = 0; i < 5; i++) {
        free(array[i]->mystring);
        free(array[i]);
    }
    free(array);

    return 0;
}