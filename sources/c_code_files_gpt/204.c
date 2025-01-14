#include <stdio.h>

// Define the type for SetElement
typedef int SetElement;

// Declare my_function
void my_function(SetElement *element) {
    printf("Value of element: %d\n", *element);
}

int main() {
    // Declare and initialize my_var
    int my_var = 10;
    
    // Cast my_var to SetElement and call my_function
    SetElement my_element = (SetElement)my_var;
    my_function(&my_element);
    
    return 0;
}