#include <stdio.h>
#include <stdlib.h>

#define MAXLENGTH 100

// Comparison function for qsort
int compare(const void *a, const void *b) {
    return (*(unsigned *)a - *(unsigned *)b);
}

// Function to sort top N elements in a circular buffer
void sort_top_n(unsigned queue[], int head, int tail, int n) {
    // Determine the number of elements in the queue
    int count = (tail - head + MAXLENGTH) % MAXLENGTH;
    if (count == 0) {
        return; // Queue is empty
    }

    // Adjust n if it exceeds the number of elements in the queue
    if (n > count) {
        n = count;
    }

    // Allocate a temporary buffer to hold the top N elements
    unsigned *temp = (unsigned *)malloc(n * sizeof(unsigned));
    if (temp == NULL) {
        perror("Unable to allocate temporary buffer");
        exit(EXIT_FAILURE);
    }

    // Copy the top N elements to the temporary buffer
    for (int i = 0; i < n; i++) {
        temp[i] = queue[(head + i) % MAXLENGTH];
    }

    // Sort the temporary buffer
    qsort(temp, n, sizeof(unsigned), compare);

    // Copy the sorted elements back to the circular buffer
    for (int i = 0; i < n; i++) {
        queue[(head + i) % MAXLENGTH] = temp[i];
    }

    // Free the temporary buffer
    free(temp);
}

int main() {
    unsigned queue[MAXLENGTH] = {20, 10, 30, 40, 50};
    int head = 0;
    int tail = 5; // Assuming 5 elements in the queue

    // Sort the top 3 elements in the queue
    sort_top_n(queue, head, tail, 3);

    // Print the sorted queue
    for (int i = head; i != tail; i = (i + 1) % MAXLENGTH) {
        printf("%u ", queue[i]);
    }
    printf("\n"); // Replaced " " with "\n"

    return 0;
}