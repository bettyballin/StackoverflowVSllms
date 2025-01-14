#include <stdio.h>
#include <stdlib.h>

// Define the compare function for qsort
int compare(const void *a, const void *b) {
    return strcmp(*(char **)a, *(char **)b);
}

// Define the lookup function
int lookup(const char *target, char *array[], size_t size) {
    for (size_t i = 0; i < size; i++) {
        if (strcmp(target, array[i]) == 0) {
            return (int)i;
        }
    }
    return -1;
}

int main() {
    char *array[] = {"apple", "banana", "cherry", "date", NULL};
    size_t size = sizeof(array) / sizeof(array[0]) - 1;

    qsort(array, size, sizeof(char *), compare);

    int index = lookup("banana", array, size);
    if (index != -1) {
        printf("Found at index %d\n", index);
    } else {
        printf("Not found\n");
    }

    return 0;
}