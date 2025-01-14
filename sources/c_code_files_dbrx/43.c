#include <stdio.h>

// Function to display elements of an array
void displayArray(int arr[], int length) {
    for (int i = 0; i < length; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    // Assuming the initialized array has 5 elements.
    int arr[] = {1, 2, 3, 4, 5};
    displayArray(arr, sizeof(arr)/sizeof(arr[0])); // Passing length of input array using divide by first element trick.
    return 0;
}