#include <stdio.h>
#include <stdlib.h>

// Function to perform binary search
int binarySearch(int arr[], int l, int r, int x) {
    while (l <= r) {
        int mid = l + (r - l) / 2;
        // Check if x is present at mid
        if (arr[mid] == x)
            return mid;
        // If x greater, ignore left half
        if (arr[mid] < x)
            l = mid + 1;
        // If x is smaller, ignore right half
        else
            r = mid - 1;
    }
    // If we reach here, the element was not present
    return -1;
}

// Example usage
int main() {
    int points[] = {2, 3, 4, 10, 40};
    int n = sizeof(points) / sizeof(points[0]);
    int x = 10;
    int result = binarySearch(points, 0, n - 1, x);
    if (result == -1)
        printf("Element not present in array\n");
    else
        printf("Element is present at index %d\n", result);
    return 0;
}