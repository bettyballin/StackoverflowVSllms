#include <stdio.h>
#include <stdlib.h>

// Define a struct to represent IData
typedef struct IData {
    // Add your structure members here
} IData;

// Function to create new data
IData* newData(size_t size) {
    return (IData*)malloc(size);
}

int main() {
    // Create new data
    IData* data = newData(sizeof(IData));

    // Check if memory allocation was successful
    if (data == NULL) {
        printf("Memory allocation failed\n");
        return -1;
    }

    // Use the allocated data
    // ...

    // Don't forget to free the allocated memory when you're done
    free(data);

    return 0;
}