#include <stdio.h>
#include <stdlib.h>

// Define the structure
typedef struct {
    int data;
} MyStruct;

// Function to create a new MyStruct instance
MyStruct* createMyStruct() {
    MyStruct* obj = malloc(sizeof(MyStruct));
    if (obj == NULL) {
        printf("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    obj->data = 0; // Initialize data to 0
    return obj;
}

// Function to destroy a MyStruct instance
void destroyMyStruct(MyStruct* obj) {
    if (obj != NULL) {
        free(obj);
    }
}

int main() {
    MyStruct* obj = createMyStruct();
    // Use obj
    obj->data = 10;
    printf("obj->data = %d\n", obj->data);
    destroyMyStruct(obj);
    return 0;
}