#include <stdio.h>

// Prototype
int your_function(int an_argument);

int main() {
    int argument = 5; // Example argument
    int result = your_function(argument);
    
    printf("Result: %d\n", result);
    
    return 0;
}

// Implementation of your_function()
int your_function(int an_argument) {
    return an_argument + 1;
}