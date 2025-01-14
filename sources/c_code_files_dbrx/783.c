#include <stdio.h>

void swap(int* a, int* b) {
    // Swapping elements at locations pointed by *a and *b
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int array[], int low, int high) {
    // Set pivot as highest element of the interval
    int pivot = array[high];
    // Index to be swapped
    int j = low - 1;
    for (int i = low; i <= high - 1; i++) {
        if (array[i] < pivot) {
            j++;
            swap(&array[j], &array[i]);
        }
    }
    // Swap index at *j and pivots positions
    swap(&array[++j], &array[high]);
    return (j);
}

void quicksort(int array[], int low, int high) {
    if (low < high) {
        // partitioning the array  and returning pivot's position
        int pi = partition(array, low, high);
        // Recursively applying quicksort algorithm below
        // then to elements above the pivot i.e., [left half] & [right half] of pivotal index[pi]
        quicksort(array, low, pi - 1);
        quicksort(array, pi + 1, high);
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n"); // fixed newline character
}

int main() {
    int arr[] = {4, 2, 7, 1, 3};
    int n = sizeof(arr) / sizeof(arr[0]);
    quicksort(arr, 0, n - 1);
    printArray(arr, n);
    return 0;
}