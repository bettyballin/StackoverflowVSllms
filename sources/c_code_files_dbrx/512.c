#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

// Function to find occurrences of specific number in an array
int count_occurrence(int arr[], int size, int num) {
    int i;
    int count = 0;

    for (i = 0; i < size; ++i) {
        if (arr[i] == num) {
            count++;
        }
    }

    return count;
}

int main() {
    int arr[] = {1, 2, 3, 4, 2, 7, 8, 8, 3};
    int size = sizeof(arr) / sizeof(arr[0]);
    int num = 2;
    int occurrence = count_occurrence(arr, size, num);

    printf("Number of occurrences of %d is: %d\n", num, occurrence);

    return 0;
}