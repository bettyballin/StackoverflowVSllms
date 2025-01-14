#include <stdio.h>
#include <stdlib.h>

void mergeArrays(int* a1, int size1, int* a2, int size2, int** mixed, int* mixedSize) {
    *mixedSize = size1 + size2;
    *mixed = (int*)malloc((*mixedSize) * sizeof(int));

    int i = 0;
    int m = 0;
    while (i < size1 || i < size2) {
        if (i < size1)
            (*mixed)[m++] = a1[i];
        if (i < size2)
            (*mixed)[m++] = a2[i];
        i++;
    }
}

int main() {
    int a1[] = {1, 3, 5};
    int size1 = sizeof(a1) / sizeof(a1[0]);
    int a2[] = {2, 4};
    int size2 = sizeof(a2) / sizeof(a2[0]);

    int* mixed = NULL;
    int mixedSize;

    mergeArrays(a1, size1, a2, size2, &mixed, &mixedSize);

    printf("Mixed array: ");
    for (int i = 0; i < mixedSize; i++) {
        printf("%d ", mixed[i]);
    }
    printf("\n");

    free(mixed); // Don't forget to free the allocated memory

    return 0;
}