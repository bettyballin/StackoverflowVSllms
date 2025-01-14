#include <stdio.h>
#include <stdlib.h>

void addValues (int **a, int *size, int num_items){
    // implementation of addValues function
    // for demonstration purposes, let's just add num_items to the array
    int new_size = *size + num_items;
    *a = realloc(*a, new_size * sizeof(int));
    for (int i = *size; i < new_size; i++) {
        (*a)[i] = 0; // initialize new elements to 0
    }
    *size = new_size;
}

int main() {
    int* a; //declare the array as 'pointer-to-any'. The actual size is controlled by realloc.
    int currentSize = 10; // initial size of the dynamic array
    a = malloc(currentSize * sizeof(*a)); // allocate memory to it first
    int counter = currentSize;

    addValues(&a, &counter, 2); //passing address-of pointers here.

    // don't forget to free the memory when you're done
    free(a);

    return 0;
}