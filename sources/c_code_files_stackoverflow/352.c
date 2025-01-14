#include <stdio.h>
#include <stdlib.h>

// Define the structure for MyObject
typedef struct MyObject {
    void (*func)(void); // Function pointer
} MyObject;

int main() {
    // Initialize MyObject
    MyObject *o = NULL;

    // This will cause a segmentation fault because o is NULL
    // o->func();

    // To fix the segmentation fault, you need to properly allocate and initialize o
    o = malloc(sizeof(MyObject));
    if (o == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Assign a function to o->func
    o->func = NULL; // Without a proper function, calling this will also cause a segmentation fault
    // To actually use it, define a function and assign it like this:
    void myFunction() {
        printf("myFunction called\n");
    }
    o->func = myFunction;
    o->func(); // Now this can be safely called

    free(o); // Clean up

    return 0;
}