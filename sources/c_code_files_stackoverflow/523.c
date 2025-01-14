#include <stdio.h>
#include <stdlib.h>

void* some_function(int error) {
    if (error) {
        return NULL;
    }
    // rest of the function implementation...
    return malloc(1);  // Replace with actual return value
}

int main() {
    int error = 1;  // Replace with actual error value
    void* result = some_function(error);
    if (result == NULL) {
        printf("Error occurred\n");
    } else {
        printf("No error occurred\n");
    }
    return 0;
}