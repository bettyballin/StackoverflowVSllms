#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stddef.h>

// Define a sample struct for demonstration
typedef struct {
    int Item;
} YourStructType;

// Define the function to set a struct member
void setStructMember(YourStructType *structPtr, int memberOffset, void *value, size_t valueSize){
    memcpy((char*)structPtr + memberOffset, value, valueSize);
}

int main() {
    // Create an instance of the struct
    YourStructType GlobalStructInstance;

    // Define a value to be set
    int value = 10;

    // Set the member variable "Item" within the struct instance
    setStructMember(&GlobalStructInstance, offsetof(YourStructType, Item), &value, sizeof(int));

    // Print the value of "Item" to verify
    printf("%d\n", GlobalStructInstance.Item);

    return 0;
}