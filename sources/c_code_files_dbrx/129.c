#include <stdio.h>
#include <stdlib.h>

// Define a structure
typedef struct MyStruct {
    int Item;
} MyStruct;

// Define the macro
#define STRUC_MEMBER(StructInstance, Member) (&((StructInstance)->Member))

// Declare the GlobalStructInstance variable
MyStruct* GlobalStructInstance;

int main() {
    // Allocate memory for GlobalStructInstance
    GlobalStructInstance = (MyStruct*) malloc(sizeof(MyStruct));

    // Use the macro to set the value of Item
    *STRUC_MEMBER(GlobalStructInstance, Item) = 1;

    // Print the value to verify
    printf("Value of Item: %d\n", GlobalStructInstance->Item);

    // Free the allocated memory
    free(GlobalStructInstance);

    return 0;
}