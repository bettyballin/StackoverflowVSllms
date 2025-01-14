#include <stdio.h>
#include <stdlib.h>

// Define the struct MyType1
typedef struct MyType1 {
    int data;
} MyType1;

// Function prototype for creating an object of type MyType1
MyType1* create_mytype1(int value) {
    MyType1* mt1 = (MyType1*) malloc(sizeof(MyType1));
    if (mt1 != NULL) {
        mt1->data = value;
    }
    return mt1;
}

// Function prototype for deleting an object of type MyType1
void delete_mytype1(MyType1* mt1) {
    if (mt1 != NULL) {
        free(mt1);
    }
}

int main() {
    // Create an instance of MyType1
    MyType1* mytype1 = create_mytype1(10);
    
    if (mytype1 != NULL) {
        printf("Value of mytype1->data: %d\n", mytype1->data);
    }

    // Delete the instance
    delete_mytype1(mytype1);

    return 0;
}