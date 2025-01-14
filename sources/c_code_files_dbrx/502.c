#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int* arr;
    size_t count;
} Array;

void array_add(Array *arr, int value) {
    arr->arr = realloc(arr->arr, (arr->count + 1) * sizeof(int));
    arr->arr[arr->count] = value;
    arr->count++;
}

int main() {
    Array arr;
    arr.arr = NULL;
    arr.count = 0;

    array_add(&arr, 5);
    array_add(&arr, 10);
    array_add(&arr, 15);

    for (size_t i = 0; i < arr.count; i++) {
        printf("%d ", arr.arr[i]);
    }
    printf("\n");

    free(arr.arr);

    return 0;
}