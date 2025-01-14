#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    void **list; // Pointer to a pointer of element (void* to allow any type)
    size_t listSize;
    size_t capacity;
    size_t elemSize;  // Size of each element in the list
} dynamicArray;

// Append function for dynamic array
void append(dynamicArray *array, void *element){
	if (array->listSize >= array->capacity) {
        // If our current capacity is not enough to fit new element,
        // Reallocate memory with increased capacity.
        size_t newCapacity = array->capacity == 0 ? 1 : array->capacity * 2;
	    array->list = realloc(array->list, sizeof(void *) * newCapacity);
	    if (array->list == NULL) {
            perror("Error: Unable to allocate memory");
            exit(EXIT_FAILURE);
        }
        // Update our capacity only after successful allocation.
	    array->capacity = newCapacity;
	}
    void *destPtr = (void *)((char*)array->list + array->listSize*sizeof(void *));
    array->list[array->listSize] = malloc(array->elemSize);
    if (array->list[array->listSize] == NULL) {
        perror("Error: Unable to allocate memory");
        exit(EXIT_FAILURE);
    }
    memcpy(array->list[array->listSize], element, array->elemSize);
    array->listSize++;
}

int main() {
    dynamicArray array;
    array.list = NULL;
    array.listSize = 0;
    array.capacity = 0;
    array.elemSize = sizeof(int);

    int num = 10;
    append(&array, &num);

    printf("%d\n", *(int *)array.list[0]);

    free(array.list[0]);
    free(array.list);

    return 0;
}