#include <stdio.h>

// Define a function that accepts an array of floats
void func(float arr[4]) {
    for (int i = 0; i < 4; i++) {
        printf("%f ", arr[i]);
    }
    printf("\n");
}

int main() {
    // Creates a temporary variable
    float tmp[4] = {1, 2, 3, 4};
    func(tmp);                   // Pass the address of the first element to func()

    // Directly without creating a named variable
    func((float[]){1, 2, 3, 4}); // Same as above but using compound literal

    return 0;
}