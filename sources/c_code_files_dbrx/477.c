#include <stdio.h>

#define MAXLENGTH 100 // define the maximum length of the buffer
#define INT_SWAP(a, b) { int t = (a); (a) = (b); (b) = t; } // define the swap macro

int main() {
    int is_sorted = 0;
    size_t size = 10; // number of elements in the top N
    int buffer[MAXLENGTH]; // pointer to the start element of the top N elements

    // initialize the buffer with some values
    for (int i = 0; i < size; i++) {
        buffer[i] = size - i; // initialize in reverse order
    }

    while (!is_sorted) {
        is_sorted = 1; // assume sorted until proven otherwise

        for (int i = 0; i < size - 1; i++) {
            int idx1 = (i + 0) % MAXLENGTH, // buffer is an array, not a pointer
                idx2 = ((i + 1) % MAXLENGTH);
            if (buffer[idx1] > buffer[idx2]) { // out of order and need to swap
                INT_SWAP(buffer[idx1], buffer[idx2]);
                is_sorted = 0;
            }
        }
    }

    // print the sorted buffer
    for (int i = 0; i < size; i++) {
        printf("%d ", buffer[i]);
    }
    printf("\n");

    return 0;
}