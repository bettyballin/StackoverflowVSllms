#include <stdio.h>

int binary_search(int array[], int target, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            low = mid + 1; // Ensure proper increment
        } else {
            high = mid - 1; // Ensure proper decrement
        }
    }
    return -1; // Return -1 if target not found
}

int main() {
    int array[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int target = 23;
    int low = 0;
    int high = sizeof(array) / sizeof(array[0]) - 1;
    int result = binary_search(array, target, low, high);
    if (result != -1) {
        printf("Target %d found at index %d\n", target, result);
    } else {
        printf("Target %d not found in the array\n", target);
    }
    return 0;
}