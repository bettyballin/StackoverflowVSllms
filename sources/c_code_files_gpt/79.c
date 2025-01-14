#include <stdio.h>
#include <stdlib.h>

typedef int ent;

int addValues(ent **a, int mSize);

int main(int argc, char** argv) {
    int mSize = 10;
    ent *a = malloc(mSize * sizeof(ent)); // Dynamically allocate initial array
    if (a == NULL) {
        perror("Failed to allocate memory");
        return 1;
    }
    int n = addValues(&a, mSize);

    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]); // Print values from array
    }
    printf("\n");
    free(a); // Free the allocated memory
    return 0;
}

int addValues(ent **a, int mSize) {
    int size = mSize;
    int i = 0;

    while (i < 20) { // Add 20 items to the array
        if (i >= size - 1) {
            size = size * 2;
            ent *temp = realloc(*a, size * sizeof(ent));
            if (temp == NULL) {
                perror("Failed to reallocate memory");
                free(*a);
                exit(1);
            }
            *a = temp;
        }
        // Add to array
        (*a)[i] = i; // Add the index as the value
        i++;
    }
    return i;
}