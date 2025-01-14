#include <stdio.h>
#include <stdlib.h>

// Define the structure for a dynamic array
typedef struct {
    size_t elemSize;     // Size of each element in the array
    void* list;          // Pointer to the dynamically allocated memory
    size_t capacity;     // Current capacity of the array
    size_t listSize;     // Number of elements in the list
} dynamicArray;

// Function to append an element to the dynamic array
void append(dynamicArray* arr, void* element) {
    // Check if the array needs to be resized
    if (arr->listSize == arr->capacity) {
        // Calculate the new capacity (double the current capacity or a minimum increase if capacity is 0)
        size_t newCapacity = arr->capacity == 0 ? 1 : arr->capacity * 2;
        
        // Allocate new memory with the new capacity
        void* newList = malloc(newCapacity * arr->elemSize);
        
        // Copy the old elements to the new memory
        for (size_t i = 0; i < arr->listSize; ++i) {
            // Calculate the offset for the current element
            size_t offset = i * arr->elemSize;
            // Copy the element from the old list to the new list
            memcpy((char*)newList + offset, (char*)arr->list + offset, arr->elemSize);
        }
        
        // Free the old memory if it's not NULL
        if (arr->list != NULL) {
            free(arr->list);
        }
        
        // Update the array's list pointer and capacity
        arr->list = newList;
        arr->capacity = newCapacity;
    }
    
    // Calculate the offset for the new element
    size_t offset = arr->listSize * arr->elemSize;
    
    // Copy the new element into the array
    memcpy((char*)arr->list + offset, element, arr->elemSize);
    
    // Increment the list size
    arr->listSize++;
}

int main() {
    dynamicArray arr;
    arr.elemSize = sizeof(int);  // Define element size as integer type here.
    arr.list = NULL;             // Starts with no elements initially.
    arr.capacity = 0;            // No allocated memory capacity at the beginning.
    arr.listSize = 0;            // Number of elements currently in list is zero.

    int x = 5, y = 10, z = 15;   // Create and initialize some integers.

    append(&arr, &x);         // Add 'x' to the dynamicArray.
    append(&arr, &y);         // Add 'y' to the dynamicArray.
    append(&arr, &z);         // Add 'z' to the dynamicArray.

    // Optionally, print the elements in the array to verify
    for (size_t i = 0; i < arr.listSize; ++i) {
        size_t offset = i * arr.elemSize;
        int value = *(int*)((char*)arr.list + offset);
        printf("%d ", value);
    }
    printf("\n");

    // Don't forget to free the allocated memory when you're done
    if (arr.list != NULL) {
        free(arr.list);
    }

    return 0;
}