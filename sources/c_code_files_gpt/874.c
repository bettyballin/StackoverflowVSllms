#include <stdio.h>
#include <stdlib.h>

// Define MyStruct
typedef struct {
    int data;
} MyStruct;

// Function to create and initialize MyStruct
MyStruct* createMyStruct() {
    MyStruct* ptr = malloc(sizeof(MyStruct));
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    // Initialize ptr
    ptr->data = 0; // Example initialization
    return ptr;
}

// Function to destroy MyStruct
void destroyMyStruct(MyStruct* ptr) {
    if (ptr != NULL) {
        // Perform necessary cleanup
        free(ptr);
    }
}

int main() {
    MyStruct* myStruct = createMyStruct();
    if (myStruct != NULL) {
        printf("MyStruct created and initialized with data: %d\n", myStruct->data);
        // Example usage
        myStruct->data = 10;
        printf("Updated data: %d\n", myStruct->data);
        destroyMyStruct(myStruct);
        printf("MyStruct destroyed\n");
    }
    return 0;
}