#include <stdio.h>

// Define a type for SetElement
typedef int SetElement;

// Function prototype for funcCall
void funcCall(SetElement element);

int main() {
    // Declare and initialize my_var
    SetElement my_var = 10;

    // Call funcCall with my_var
    funcCall(my_var);

    return 0;
}

// Define the funcCall function
void funcCall(SetElement element) {
    printf("funcCall called with element: %d\n", element);
}