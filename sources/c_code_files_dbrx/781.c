#include <stdio.h>

int main(void) {
    char tmp, arr[100];
    int i, k;

    // Initialize the array with some values
    for (i = 0; i < 100; i++) {
        arr[i] = 'a' + (i % 26); // Fill with lowercase letters
    }

    // Print the original array
    printf("Original array:\n");
    for (i = 0; i < 100; i++) {
        printf("%c ", arr[i]);
    }
    printf("\n");

    // Example operation: shift each character by 1
    for (k = 0; k < 1; k++) {
        tmp = arr[99]; // Save the last element
        for (i = 99; i > 0; i--) {
            arr[i] = arr[i - 1]; // Shift elements to the right
        }
        arr[0] = tmp; // Move the saved last element to the first position
    }

    // Print the modified array
    printf("Modified array:\n");
    for (i = 0; i < 100; i++) {
        printf("%c ", arr[i]);
    }
    printf("\n");

    return 0;
}